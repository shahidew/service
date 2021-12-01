package ir.maktab.web;

import ir.maktab.config.LastViewInterceptor;
import ir.maktab.data.entity.Customer;
import ir.maktab.dto.ConfirmationTokenDto;
import ir.maktab.dto.CustomerDto;
import ir.maktab.service.ConfirmationTokenService;
import ir.maktab.service.CustomerService;
import ir.maktab.service.EmailService;
import ir.maktab.service.SecurityService;
import ir.maktab.service.exception.InValidInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("customer")
@SessionAttributes("customer")
public class CustomerController {
    private final CustomerService service;
    private final SecurityService securityService;
    private final ConfirmationTokenService tokenService;
    private final EmailService emailService;
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    public CustomerController(CustomerService service, SecurityService securityService, ConfirmationTokenService tokenService, EmailService emailService) {
        this.service = service;
        this.securityService = securityService;
        this.tokenService = tokenService;
        this.emailService = emailService;
    }


    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("customer/loginCustomer", "customer", new CustomerDto());
    }

    @PostMapping("/login")
    public String loginCustomer( @RequestParam("emailAddress") String email,
                                 @RequestParam("password") String password,
                                Model model) throws InValidInputException {
        Customer customer = service.login(email, password);
        model.addAttribute("customer",customer);
       // securityService.autoLogin(email,password);
        return "customer/welcomeCustomer";
    }

  /*  @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("customer/registerCustomer", "customer", new CustomerDto());
    }*/

   /* @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") @Valid CustomerDto customerDto,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "customer/registerCustomer";
        }
        service.create(customerDto);
        //securityService.autoLogin(customerDto.getEmailAddress(), customerDto.getPassword());
        //model.addAttribute("customer",customerDto);
        return "customer/welcomeCustomer";
    }*/


    @GetMapping("/register")
    public ModelAndView displayRegistration(ModelAndView  modelAndView){
        modelAndView.addObject("customer", new CustomerDto());
        modelAndView.setViewName("customer/registerCustomer");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView, @ModelAttribute("customer") CustomerDto customerDto) throws InValidInputException {
        CustomerDto dto = service.findCustomerByEmail(customerDto.getEmailAddress());
        if(dto != null) {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else {
            service.create(customerDto);

            ConfirmationTokenDto confirmationTokenDto = new ConfirmationTokenDto(customerDto);
            tokenService.create(confirmationTokenDto);


            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(customerDto.getEmailAddress());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("13sh78m@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + confirmationTokenDto.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailAddress", customerDto.getEmailAddress());

            modelAndView.setViewName("customer/successfulRegisteration");
        }
        return modelAndView;
    }


    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken) throws InValidInputException {

        ConfirmationTokenDto token = tokenService.findByConfirmationToken(confirmationToken);
        if(token != null)
        {
            CustomerDto customerDto = service.findCustomerByEmail(token.getUserDto().getEmailAddress());
            customerDto.setEnabled(true);
            service.create(customerDto);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

    @PostMapping ("/changePass")
    public String changePass(@SessionAttribute("customer") CustomerDto customerDto, Model model) {
        Customer customer = service.changePassword(customerDto);
        model.addAttribute("customer",customer);
        return "customer/welcomeCustomer";
    }

    //TODO
    @GetMapping("/showCredit")
    public String showCommentsPage(@SessionAttribute("customer") CustomerDto customerDto,
                                   Model model) {
        model.addAttribute("customer.credit", customerDto.getCredit());
        return "showCredit";
    }

    //TODO
    @GetMapping("/showOrders")
    public ModelAndView showOrders(@SessionAttribute("customer") CustomerDto customerDto) {
        return new ModelAndView("showOrdersListOfCustomer", "orders", customerDto.getOrderDtos());
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        logger.error("exception occurred: " + ex.getMessage());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }


}
