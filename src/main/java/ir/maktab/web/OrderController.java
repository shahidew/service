package ir.maktab.web;

import ir.maktab.data.enums.OfferStatus;
import ir.maktab.data.enums.OrderState;
import ir.maktab.dto.*;
import ir.maktab.service.*;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("order")
public class OrderController {
    private final OrderService service;
    private final OfferService offerService;
    private final CustomerService customerService;
    private final ExpertService expertService;
    private final SuperServiceService superService;
    private final SubServiceService subService;

    public OrderController(OrderService service, OfferService offerService, CustomerService customerService, ExpertService expertService, SuperServiceService superService, SubServiceService subService) {
        this.service = service;
        this.offerService = offerService;
        this.customerService = customerService;
        this.expertService = expertService;
        this.superService = superService;
        this.subService = subService;
    }


    @GetMapping("/record")
    public ModelAndView showAddOrderPage(ModelAndView modelAndView) throws NotFoundException {
        List<SubServiceDto> subServiceDtos = subService.getAllSubService();
        modelAndView.addObject("subServices", subServiceDtos);
        modelAndView.addObject("order", new OrderDto());
        modelAndView.setViewName("order/recordOrder");
        return modelAndView;
    }


    @PostMapping("/record")
    public String addOrder(@ModelAttribute("order") OrderDto orderDto,
                           @RequestParam("emailAddress") String email,
                           @RequestParam("subServiceName") String name,
                           BindingResult bindingResult, Model model) throws InValidInputException, NotFoundException {
        if (bindingResult.hasErrors()) {
            return "order/recordOrder";
        }
        CustomerDto customerByEmail = customerService.findCustomerByEmail(email);
        orderDto.setCustomerDto(customerByEmail);
        Optional<SubServiceDto> subServiceDto = subService.getSubServiceByName(name);
        OrderDto dto = service.create(orderDto, customerByEmail, subServiceDto.get());
        model.addAttribute("customer",customerByEmail);
        return "customer/welcomeCustomer";
    }


    /*@GetMapping("/addOffersToOrder")
    public ModelAndView showOrderListToExpert(@RequestParam(value = "emailAddress") String email,
                                              Model model) throws InValidInputException {
        Optional<ExpertDto> expertByEmail = expertService.getExpertByEmail(email);
        List<SubServiceDto> subServiceDtos = expertByEmail.get().getSubServiceDtos();
        List<OrderDto> orderDtos = subServiceDtos.get(0).getOrderDtos();

        return new ModelAndView("showOrdersByExpert", "orders", orderDtos);

    }

    @PostMapping("/addOffersToOrder")
    public String addOffersToOrder(@RequestParam(value = "emailAddress") String email,
                                   @RequestParam(value = "order_Id") Long orderId,
                                   @RequestParam(value = "proposedPrice") Double proposedPrice,
                                   @RequestParam(value = "durationOfWork") Long durationOfWork,
                                   @RequestParam(value = "startTime") Date startTime,
                                   Model model) throws InValidInputException, NotFoundException {
        Optional<ExpertDto> expertByEmail = expertService.getExpertByEmail(email);
        Optional<OrderDto> orderDto = service.getById(orderId);

        OfferDto offerDto = new OfferDto().setOrderDto(orderDto.get())
                .setDurationOfWork(durationOfWork)
                .setProposedPrice(proposedPrice)
                .setStartTime(startTime)
                .setExpertDto(expertByEmail.get());

        offerDto.setOfferStatus(OfferStatus.REGISTERED);
        offerService.create(offerDto);
        orderDto.get().getOfferDtos().add(offerDto);
        orderDto.get().setOrderState(OrderState.WaitingForSpecialistSelection);
        service.update(orderDto.get());

        return "expert/welcomeExpert";
    }*/




  /*  @PostMapping("/showOrderListForCustomer")
    public ModelAndView showOrdersByCustomer(@SessionAttribute("customer")CustomerDto customerDto) throws NotFoundOrderException {
        return new ModelAndView("orderListForCustomer","orderList",service.findAllByCustomer(customerDto));
    }

    @PostMapping("/showOrderListForExpert")
    public ModelAndView showOrdersByExpert(@SessionAttribute("expert")ExpertDto expertDto) throws NotFoundOrderException {
        return new ModelAndView("orderListForExpert","orderList",service.findAllByExpert(expertDto));
    }
*/

}
