package ir.maktab.data.repository;

import ir.maktab.data.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findManagerByPasswordAndEmailAddress(String password, String email);

    Optional<Manager> findByEmailAddress(String email);
}
