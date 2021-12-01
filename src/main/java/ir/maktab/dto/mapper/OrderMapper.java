package ir.maktab.dto.mapper;

import ir.maktab.data.entity.Order;
import ir.maktab.dto.OrderDto;

import java.util.List;

public interface OrderMapper {

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<Order> toOrders(List<OrderDto> dtos);

    List<OrderDto> toOrderDtos(List<Order> orders);
}
