package ir.maktab.data.repository;

import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.SubService;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.SuperService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Long> {

    Optional<SubService> findSubServiceBySuperService(SuperService superService);

    Optional<SubService> findSubServiceByName(String name);

    List<SubService> findSubServiceByBasePrice(double basePrice);

    List<SubService> findSubServiceByExpertsContains(Expert expert);

    List<SubService> findSubServiceByOrdersContains(Order order);


}
