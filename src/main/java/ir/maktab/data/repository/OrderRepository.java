package ir.maktab.data.repository;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.SubService;
import ir.maktab.data.enums.OrderState;
import ir.maktab.dto.SubServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderState(OrderState orderState);

    List<Order> findAllByCustomer(Customer customer);

    List<Order> findAllByExpert(Expert expert);

    List<Order> findOrdersBySubService(SubServiceDto subServiceDto);
}
