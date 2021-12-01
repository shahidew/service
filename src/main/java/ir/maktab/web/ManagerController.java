package ir.maktab.web;

import ir.maktab.config.LastViewInterceptor;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.ManagerService;
import ir.maktab.service.SecurityService;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("management")
@SessionAttributes("management")
public class ManagerController {

    private final MessageSource messageSource;
    private final SecurityService securityService;
    private static final Logger logger = LogManager.getLogger(ManagerController.class);

    private final ManagerService service;

    public ManagerController(MessageSource messageSource, SecurityService securityService, ManagerService service) {
        this.messageSource = messageSource;
        this.securityService = securityService;
        this.service = service;
    }


    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("manager/loginManager","manager",new ManagerDto());
    }

    @PostMapping("/login")
    public String loginManager(@ModelAttribute("manager") ManagerDto managerDto,
                               Model model) throws NotFoundException, InValidInputException {
        service.login(managerDto);
       // securityService.autoLogin(managerDto.getEmailAddress(), managerDto.getPassword());
        model.addAttribute("manager",managerDto);
        return "manager/managerPage";
    }

    @GetMapping("/managerPage")
    public String managerPage(){
        return "manager/managerPage";
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ModelAndView loginExceptionHandler(NotFoundException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", ex.getMessage());
        model.put("manager", new ManagerDto());
        return new ModelAndView("manager/loginManager", model);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        logger.error("exception occurred: " + ex.getMessage());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }
}
