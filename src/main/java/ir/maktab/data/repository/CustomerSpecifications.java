package ir.maktab.data.repository;

import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface CustomerSpecifications {

    static Specification<Customer> filterCustomers(CustomerDto dto) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            //criteriaBuilder.treat() : for inheritance
            List<Predicate> predicates = new ArrayList<>();

            //TODO Role && underservice
            if (dto.getFullName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("fullName"), dto.getFullName()));
            }
            if (dto.getEmailAddress() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), dto.getEmailAddress()));
            }
            if (dto.getCredit() != null) {
                predicates.add(criteriaBuilder.equal(root.get("credit"), dto.getCredit()));
            }
            return criteriaQuery.where(predicates.toArray(predicates.toArray(new Predicate[0]))).getRestriction();
        });
    }
}
