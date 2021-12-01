package ir.maktab.data.repository;

import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.User;
import ir.maktab.dto.FilterUserDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserSpecifications {
    static Specification<User> filterUsers(FilterUserDto dto) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            List<Predicate> predicates = new ArrayList<>();
            Root<Expert> expertRoot = criteriaBuilder.treat(root, Expert.class);
            if (dto.getFullName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("fullName"), dto.getFullName()));
            }
            if (dto.getEmailAddress() != null) {
                predicates.add(criteriaBuilder.equal(root.get("emailAddress"), dto.getEmailAddress()));
            }
            if (dto.getUserRole() != null) {
                predicates.add(criteriaBuilder.equal(root.get("userRole"), dto.getUserRole()));
            }
            if (dto.getCredit() != null) {
                predicates.add(criteriaBuilder.equal(expertRoot.get("credit"), dto.getCredit()));
            }
            if ( dto.getSubServiceDto()!= null  ) {
                predicates.add(criteriaBuilder.isMember(dto.getSubServiceDto(), expertRoot.get("subServices")));
            }
            query.select(root).where(predicates.toArray(new Predicate[0]));
            return query.getRestriction();
        };
    }
}
