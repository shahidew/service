package ir.maktab.service;

import ir.maktab.data.enums.OrderState;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderDto create(OrderDto dto, CustomerDto customerDto, SubServiceDto subServiceDto);

    void update(OrderDto dto);

    void remove(OrderDto dto);

    List<OrderDto> getAll() throws NotFoundException;

    List<OrderDto> getByOrderState(OrderState orderState) throws NotFoundException;

    List<OrderDto> findAllByCustomer(CustomerDto customerDto) throws NotFoundException;

    List<OrderDto> findAllByExpert(ExpertDto expertDto) throws NotFoundException;

    Optional<OrderDto> getById(Long orderId) throws NotFoundException;

    void addService(OrderDto dto, SubServiceDto subServiceDto);

    List<OrderDto> getBySubService(SubServiceDto subServiceDto) throws NotFoundException;

}
