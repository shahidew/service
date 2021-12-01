package ir.maktab.service;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.SubService;
import ir.maktab.data.enums.OrderState;
import ir.maktab.data.repository.OrderRepository;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.mapper.OrderMapper;
import ir.maktab.dto.mapper.SubServiceMapper;
import ir.maktab.dto.mapper.user.CustomerMapper;
import ir.maktab.dto.mapper.user.ExpertMapper;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final ExpertMapper expertMapper;
    private final CustomerMapper customerMapper;
    private final SubServiceMapper serviceMapper;

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper, ExpertMapper expertMapper, CustomerMapper customerMapper, SubServiceMapper serviceMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.expertMapper = expertMapper;
        this.customerMapper = customerMapper;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public OrderDto create(OrderDto dto, CustomerDto customerDto, SubServiceDto subServiceDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        Order order = mapper.toOrder(dto);
        SubService subService = serviceMapper.toSubService(subServiceDto);
        order.setOrderState(OrderState.WaitingForExpertSuggestions);
        repository.save(order);
        order.setCustomer(customer);
        order.setSubService(subService);
        customer.getOrders().add(order);
        subService.getOrders().add(order);
        repository.save(order);
        return dto;
    }

    @Override
    public void update(OrderDto dto) {
        repository.save(mapper.toOrder(dto));
    }

    @Override
    public void remove(OrderDto dto) {
        repository.delete(mapper.toOrder(dto));
    }

    @Override
    public List<OrderDto> getAll() throws NotFoundException {
        if (repository.findAll().isEmpty()) {
            throw new NotFoundException("not found any order");
        }
        return mapper.toOrderDtos(repository.findAll());
    }

    @Override
    public List<OrderDto> getByOrderState(OrderState orderState) throws NotFoundException {
        List<Order> orders = repository.findByOrderState(orderState);
        if (orders.isEmpty()) {
            throw new NotFoundException("not found any order by this status...");
        } else {
            return mapper.toOrderDtos(orders);
        }
    }


    @Override
    public List<OrderDto> findAllByCustomer(CustomerDto customerDto) throws NotFoundException {
        Customer customer = customerMapper.toCustomer(customerDto);
        List<Order> orders = repository.findAllByCustomer(customer);
        if (orders.isEmpty()) {
            throw new NotFoundException("not found any order by this customer...");
        } else {
            return mapper.toOrderDtos(orders);
        }
    }

    @Override
    public List<OrderDto> findAllByExpert(ExpertDto expertDto) throws NotFoundException {
        Expert expert = expertMapper.toExpert(expertDto);
        List<Order> orders = repository.findAllByExpert(expert);
        if (orders.isEmpty()) {
            throw new NotFoundException("not found any order by this expert...");
        } else {
            return mapper.toOrderDtos(orders);
        }
    }

    @Override
    public Optional<OrderDto> getById(Long orderId) throws NotFoundException {
        Optional<Order> order = repository.findById(orderId);
        if (!order.isPresent()) {
            throw new NotFoundException("not found any order by this id...");
        }
        OrderDto orderDto = mapper.toOrderDto(order.get());
        return Optional.ofNullable(orderDto);
    }

    @Override
    public void addService(OrderDto dto, SubServiceDto subServiceDto) {
        Order order = mapper.toOrder(dto);
        SubService subService = serviceMapper.toSubService(subServiceDto);
        order.setSubService(subService);
        repository.save(order);
    }

    @Override
    public List<OrderDto> getBySubService(SubServiceDto subServiceDto) throws NotFoundException {
        SubService subService = serviceMapper.toSubService(subServiceDto);
        List<Order> orders = repository.findOrdersBySubService(subServiceDto);
        if (orders.isEmpty()) {
            throw new NotFoundException("not found any order by this subService...");
        } else {
            return mapper.toOrderDtos(orders);
        }
    }
}
