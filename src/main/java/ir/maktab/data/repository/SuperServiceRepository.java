package ir.maktab.data.repository;

import ir.maktab.data.entity.SubService;
import ir.maktab.data.entity.SuperService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperServiceRepository extends JpaRepository<SuperService, Long> {

    Optional<SuperService> findSuperServiceByName(String name);

    Optional<SuperService> findSuperServiceBySubServicesIsContaining(SubService subService);

}
