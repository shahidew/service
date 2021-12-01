package ir.maktab.web;

import ir.maktab.config.LastViewInterceptor;
import ir.maktab.data.enums.OrderState;
import ir.maktab.dto.*;
import ir.maktab.service.*;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("expert")
@SessionAttributes("expert")
public class ExpertController {
    private final ExpertService service;
    private final SubServiceService subService;
    private final OfferService offerService;
    private final OrderService orderService;
    private final ConfirmationTokenService tokenService;
    private final EmailService emailService;
    private static final Logger logger = LogManager.getLogger(ExpertController.class);

    public ExpertController(ExpertService service, SubServiceService subService, OfferService offerService, OrderService orderService, ConfirmationTokenService tokenService, EmailService emailService) {
        this.service = service;
        this.subService = subService;
        this.offerService = offerService;
        this.orderService = orderService;
        this.tokenService = tokenService;
        this.emailService = emailService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "expert/loginExpert";
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestParam("emailAddress") String email, @RequestParam("password") String password, Model model) throws NotFoundException{
        Optional<ExpertDto> expertDto = service.login(email, password);
        model.addAttribute("expert",expertDto.get());
        //securityService.autoLogin(email,password);
        return "expert/welcomeExpert";
    }

  /*  @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("expert/registerExpert", "expert", new ExpertDto());
    }

    @PostMapping("/register")
    public String registerExpert(@ModelAttribute("expert")  ExpertDto expertDto,
                                 @RequestParam("imageF") MultipartFile image,
                                 BindingResult bindingResult, Model model) throws IOException {
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "expert/registerExpert";
        }
        service.register(expertDto, image);
       // securityService.autoLogin(expertDto.getEmailAddress(),expertDto.getPassword());
        model.addAttribute("expertRegistered",expertDto);
        return "expert/welcomeExpert";
    }*/

    @GetMapping("/register")
    public ModelAndView displayRegistration(ModelAndView  modelAndView){
        modelAndView.addObject("expert", new ExpertDto());
        modelAndView.setViewName("expert/registerExpert");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerExpert(ModelAndView modelAndView, @ModelAttribute("expert") ExpertDto expertDto) throws InValidInputException {
        ExpertDto dto = service.findExpertByEmail(expertDto.getEmailAddress());
        if(dto != null) {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else {
            service.create(expertDto);

            ConfirmationTokenDto confirmationTokenDto = new ConfirmationTokenDto(expertDto);
            tokenService.create(confirmationTokenDto);


            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(expertDto.getEmailAddress());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("13sh78m@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + confirmationTokenDto.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailAddress", expertDto.getEmailAddress());

            modelAndView.setViewName("expert/successfulRegisterExpert");
        }
        return modelAndView;
    }

    @PostMapping ("/changePass")
    public String changePass(@SessionAttribute("expert") ExpertDto expertDto, Model model) {
        service.changePassword(expertDto);
        return "expert/welcomeExpert";
    }


    @GetMapping("/chooseService")
    public ModelAndView showServiceListPage(ModelAndView modelAndView) throws NotFoundException {
        modelAndView.addObject("subServices", subService.getAllSubService());
        modelAndView.setViewName("expert/chooseService");
        return modelAndView;
    }

    @PostMapping("/chooseService")
    public String chooseService(@RequestParam("emailAddress") String  email,
                                @RequestParam("subServiceName") String name) throws NotFoundException, InValidInputException {
        Optional<SubServiceDto> subServiceDto = subService.getSubServiceByName(name);
        Optional<ExpertDto> expert = service.getExpertByEmail(email);
        service.addService(expert.get(), subServiceDto.get());
        return "expert/welcomeExpert";
    }

    //TODO
    @GetMapping("/showComment")
    public ModelAndView showCommentsPage(@SessionAttribute("expert") ExpertDto expertDto) {
        return new ModelAndView("showComment", "comments", expertDto.getComments());
    }

    //TODO
    @GetMapping("/showOrders")
    public ModelAndView showOrders(@SessionAttribute("expert") ExpertDto expertDto) {
        return new ModelAndView("showOrdersListOfExpert", "orders", expertDto.getOrders());
    }

    @GetMapping("/addOffer")
    public ModelAndView showOffers(@SessionAttribute("expert") ExpertDto expertDto, Model model) throws NotFoundException {
        List<SubServiceDto> subServiceDtos = expertDto.getSubServiceDtos();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (int i = 0; i < subServiceDtos.size(); i++) {
           orderDtos = orderService.getBySubService(subServiceDtos.get(i));
        }
        model.addAttribute("orders", orderDtos);
        return new ModelAndView("showOrdersByExpert", "offer", new OfferDto());
    }

    @PostMapping("/addOffer")
    public String addOffersToOrder(@ModelAttribute("offer") @Valid OfferDto offerDto,
                                   @SessionAttribute("expert") ExpertDto expertDto,
                                   @RequestParam(value = "orderId") Long orderId,
                                   Model model) throws NotFoundException {
        Optional<OrderDto> orderDto = orderService.getById(orderId);
        offerService.create(offerDto, expertDto, orderDto.get());
        orderDto.get().setOrderState(OrderState.WaitingForSpecialistSelection);
        orderService.update(orderDto.get());
        return "expert/welcomeExpert";
    }


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        logger.error("exception occurred: " + ex.getMessage());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }
}
