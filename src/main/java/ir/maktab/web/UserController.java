package ir.maktab.web;


import ir.maktab.data.entity.ConfirmationToken;
import ir.maktab.data.repository.ConfirmationTokenRepository;
import ir.maktab.dto.FilterUserDto;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.mapper.user.UserMapper;
import ir.maktab.service.EmailService;
import ir.maktab.service.UserService;
import ir.maktab.service.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private final UserService userService;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailService emailService;
    private final UserMapper mapper;

    public UserController(UserService userService, ConfirmationTokenRepository confirmationTokenRepository, EmailService emailService, UserMapper mapper) {
        this.userService = userService;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailService = emailService;
        this.mapper = mapper;
    }


    @GetMapping("/filter")
    public String showUserList(Model model) {
         model.addAttribute("fuDto",new FilterUserDto());
        return "user/filterUser";
    }


    @PostMapping("/filter")
    public ModelAndView searchProducts(@ModelAttribute("fuDto") FilterUserDto dto) {
        List<UserDto> userDtos = userService.filterUsers(dto);

        return new ModelAndView("user/filterUser", "userDtos", userDtos);
    }

    @GetMapping("/register")
    public ModelAndView displayRegistration(ModelAndView  modelAndView, UserDto userDto){
        modelAndView.addObject("userDto", userDto);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView, UserDto userDto) throws NotFoundException {

        UserDto existingUser = userService.getUserByEmail(userDto.getEmailAddress()).get();
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else
        {
            userService.create(userDto);

            ConfirmationToken confirmationToken = new ConfirmationToken(mapper.toUser(userDto));

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userDto.getEmailAddress());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("YOUR EMAIL ADDRESS");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailId", userDto.getEmailAddress());

            modelAndView.setViewName("customer/successfulRegisteration");
        }
        return modelAndView;
    }


    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken) throws NotFoundException {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            UserDto user = userService.getUserByEmail(token.getUser().getEmailAddress()).get();
            user.setEnabled(true);
            userService.create(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

}
