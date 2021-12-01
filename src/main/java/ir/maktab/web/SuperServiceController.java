package ir.maktab.web;

import ir.maktab.data.entity.SuperService;
import ir.maktab.dto.SuperServiceDto;
import ir.maktab.service.SuperServiceService;
import ir.maktab.service.exception.DuplicateException;
import ir.maktab.service.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("superService")
public class SuperServiceController {
    private final SuperServiceService superService;
    private static final Logger logger = LogManager.getLogger(SuperServiceController.class);

    @Autowired
    public SuperServiceController(SuperServiceService superService) {
        this.superService = superService;
    }


    @GetMapping("/record")
    public ModelAndView showCreateServicePage() {
        return new ModelAndView("service/recordSuperService", "superService", new SuperService());
    }

    @PostMapping("/record")
    public String createBaseService(@ModelAttribute("superService") @Valid SuperServiceDto superServiceDto,
                                    BindingResult bindingResult, Model model) throws DuplicateException {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "service/recordSuperService";
        }
        SuperServiceDto dto = superService.create(superServiceDto);
        return "manager/managerPage";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException e) {
        logger.error("");
        return new ModelAndView("");
    }
}
