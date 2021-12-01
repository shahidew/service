package ir.maktab.web;

import ir.maktab.data.enums.OrderState;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.OfferService;
import ir.maktab.service.OrderService;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("offer")
public class OfferController {
    private final ExpertService expertService;
    private final OfferService service;
    private final OrderService orderService;

    public OfferController(ExpertService expertService, OfferService service, OrderService orderService) {
        this.expertService = expertService;
        this.service = service;
        this.orderService = orderService;
    }

   /* @GetMapping("/getEmail")
    public String getPage(){
        return "expert/getEmail";
    }

    @PostMapping("/getEmail")
    public String showOrderList(@RequestParam("emailAddress") String email, Model model) throws InValidInputException {
        Optional<ExpertDto> expertByEmail = expertService.getExpertByEmail(email);
        List<SubServiceDto> subServiceDtos = expertByEmail.get().getSubServiceDtos();
        List<OrderDto> orderDtos = subServiceDtos.get(0).getOrderDtos();
        model.addAttribute("orders", orderDtos);
        model.addAttribute("order", new OrderDto());
        return "showOrdersByExpert";
    }*/



 /*   @GetMapping("/addOffersToOrder")
    public ModelAndView showOrderListToExpert(@RequestParam("emailAddress") String email,
                                              Model model) throws InValidInputException {
        Optional<ExpertDto> expertByEmail = expertService.getExpertByEmail(email);
        List<SubServiceDto> subServiceDtos = expertByEmail.get().getSubServiceDtos();
        List<OrderDto> orderDtos = subServiceDtos.get(0).getOrderDtos();
        model.addAttribute("orders", orderDtos);
        return new ModelAndView("showOrdersByExpert", "offer", new OfferDto());
    }*/

  /*  @PostMapping("/addOffersToOrder")
    public String addOffersToOrder(@ModelAttribute("offer") @Valid OfferDto offerDto,
                                   @RequestParam(value = "emailAddress") String email,
                                   @RequestParam(value = "orderId") Long orderId,
                                   Model model) throws InValidInputException, NotFoundException {
        Optional<ExpertDto> expertByEmail = expertService.getExpertByEmail(email);
        Optional<OrderDto> orderDto = orderService.getById(orderId);
        service.create(offerDto, expertByEmail.get(), orderDto.get());
        orderDto.get().setOrderState(OrderState.WaitingForSpecialistSelection);
        orderService.update(orderDto.get());
        return "expert/welcomeExpert";
    }*/
}
