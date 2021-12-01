package ir.maktab.dto.mapper;

import ir.maktab.data.entity.Order;
import ir.maktab.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {
   private final SubServiceMapper serviceMapper;

    public OrderMapperImpl(SubServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    @Override
    public Order toOrder(OrderDto orderDto) {
        return new Order()
                .setId(orderDto.getId())
                .setOrderDate(orderDto.getOrderDate())
                .setAddress(orderDto.getAddress())
                .setProposedPrice(orderDto.getProposedPrice())
                .setDoneDate(orderDto.getDoneDate())
                .setJobDescription(orderDto.getJobDescription())
                .setOrderState(orderDto.getOrderState());
    }

    @Override
    public OrderDto toOrderDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
                .setOrderDate(order.getOrderDate())
                .setAddress(order.getAddress())
                .setProposedPrice(order.getProposedPrice())
                .setDoneDate(order.getDoneDate())
                .setJobDescription(order.getJobDescription())
                .setOrderState(order.getOrderState())
                .setSubServiceDto(serviceMapper.toSubServiceDto(order.getSubService()));
    }

    @Override
    public List<Order> toOrders(List<OrderDto> dtos) {
        List<Order> orders = new ArrayList<>();
        if (dtos.isEmpty()) {
            return orders;
        }
        orders = dtos.stream().map(this::toOrder).collect(Collectors.toList());
        return orders;
    }

    @Override
    public List<OrderDto> toOrderDtos(List<Order> orders) {
        List<OrderDto> dtos = new ArrayList<>();
        if (orders.isEmpty()) {
            return dtos;
        }
        dtos = orders.stream().map(this::toOrderDto).collect(Collectors.toList());
        return dtos;
    }
}
