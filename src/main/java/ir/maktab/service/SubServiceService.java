package ir.maktab.service;

import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.Order;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.SuperServiceDto;
import ir.maktab.service.exception.DuplicateException;
import ir.maktab.service.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface SubServiceService {

    SubServiceDto create(SubServiceDto dto, SuperServiceDto superServiceDto) throws DuplicateException;

    void update(SubServiceDto dto) throws NotFoundException;

    void remove(SubServiceDto dto) throws NotFoundException;

    List<SubServiceDto> getAllSubService() throws NotFoundException;

    Optional<SubServiceDto> getSubServiceById(Long id) throws NotFoundException;

    Optional<SubServiceDto> getSubServiceByName(String name) throws NotFoundException;

    List<SubServiceDto> getSubServiceByBasePrice(double basePrice) throws NotFoundException;

    List<SubServiceDto> getSubServiceByExpertsContains(Expert expert) throws NotFoundException;

    List<SubServiceDto> getSubServiceByOrdersContains(Order order) throws NotFoundException;


    void addExperts(SubServiceDto subServiceDto, ExpertDto expertDto);
}
