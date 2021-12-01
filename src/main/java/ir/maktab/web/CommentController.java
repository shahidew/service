package ir.maktab.web;

import ir.maktab.config.LastViewInterceptor;
import ir.maktab.dto.CommentDto;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.service.CommentService;
import ir.maktab.service.CustomerService;
import ir.maktab.service.ExpertService;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("comment")
public class CommentController {
    private final MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(CommentController.class);
    private final CommentService service;
    private final CustomerService customerService;
    private final ExpertService expertService;

    public CommentController(MessageSource messageSource, CommentService service, CustomerService customerService, ExpertService expertService) {
        this.messageSource = messageSource;
        this.service = service;
        this.customerService = customerService;
        this.expertService = expertService;
    }

    @GetMapping("/record")
    public ModelAndView showCreateCommentPage() {
        return new ModelAndView("comment/orderComment", "comment", new CommentDto());
    }

    @PostMapping("/record")
    public String createComment(@RequestParam(value = "emailAddress") String email,
                                @RequestParam(value = "expertEmail") String expertEmail,
                                @ModelAttribute("comment") CommentDto commentDto) throws InValidInputException, NotFoundException {
        CustomerDto customerByEmail = customerService.findCustomerByEmail(email);
        Optional<ExpertDto> expertById = expertService.getExpertByEmail(expertEmail);
        service.create(commentDto, expertById.get(), customerByEmail);
        logger.info("comment save...");
        return "customer/welcomeCustomer";
    }


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        logger.error("exception occurred: " + ex.getMessage());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

}