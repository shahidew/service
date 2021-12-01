package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.SuperServiceDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.SuperServiceService;
import ir.maktab.service.exception.DuplicateException;
import ir.maktab.service.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("subService")
public class SubServiceController {
    private final SubServiceService subService;
    private final SuperServiceService superService;
    private final ExpertService expertService;
    private static final Logger logger = LogManager.getLogger(SubServiceController.class);

    public SubServiceController(SubServiceService subService, SuperServiceService superService, ExpertService expertService) {
        this.subService = subService;
        this.superService = superService;
        this.expertService = expertService;
    }


    @GetMapping("/record")
    public ModelAndView showRecordSubServicePage(ModelAndView mv) throws NotFoundException {
        List<SuperServiceDto> superServiceDtos = superService.getAllSuperService();
        mv.addObject("superServices",superServiceDtos);
        SubServiceDto subServiceDto = new SubServiceDto();
        subServiceDto.setSuperServiceDto(superServiceDtos.get(0));
        mv.addObject("subService",subServiceDto);
        mv.setViewName("service/recordSubService");
        return mv;
    }


    @PostMapping("/record")
    public String createSubService(@ModelAttribute("subService") @Valid SubServiceDto subServiceDto,
                                   @RequestParam("superServiceName") String name,
                                   BindingResult bindingResult, Model model) throws NotFoundException, DuplicateException {
        Optional<SuperServiceDto> superServiceByName = superService.getSuperServiceByName(name);
        SubServiceDto dto = subService.create(subServiceDto, superServiceByName.get());
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "service/recordSubService";
        }
        return "manager/managerPage";
    }


    @GetMapping("/addExpert")
    public String showAddExpertPage(Model model) throws NotFoundException {
        List<SubServiceDto> subServices = subService.getAllSubService();
        model.addAttribute("subServices", subServices);
        List<ExpertDto> expertDtos = expertService.getAllExpert();
        model.addAttribute("experts", expertDtos);
        return "service/appointmentExpertToService";
    }

    @PostMapping("/addExpert")
    public String addExpert(@RequestParam("subServiceName") String subServiceName,
                            @RequestParam("expertId") Long id) throws NotFoundException {
        Optional<SubServiceDto> subServiceDto = subService.getSubServiceByName(subServiceName);
        Optional<ExpertDto> expertDto = expertService.getExpertById(id);
        if (subServiceDto.isPresent() && expertDto.isPresent()){
            logger.info("...adding started...");
            subService.addExperts(subServiceDto.get(), expertDto.get());
            expertService.addService(expertDto.get(),subServiceDto.get());
            logger.info("expert added to sub service");
            return "manager/managerPage";
        }
        else {
            logger.error("expert or subService isn't exist...");
            return "service/appointmentExpertToService";
        }
    }


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException e) {
        logger.error("");
        return new ModelAndView("");
    }

}
