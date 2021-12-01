package ir.maktab.data.repository;

import ir.maktab.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    Optional<Customer> findCustomerByCredit(Double credit);

    Optional<Customer> findCustomerByEmailAddressAndPassword(String email, String Password);

    Optional<Customer> findCustomerByEmailAddress(String email);


}
