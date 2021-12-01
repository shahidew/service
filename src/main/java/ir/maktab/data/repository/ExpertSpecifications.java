package ir.maktab.data.repository;

import ir.maktab.data.entity.SubService;
import ir.maktab.data.entity.Expert;
import ir.maktab.dto.ExpertDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface ExpertSpecifications {
    static Specification<Expert> filterExperts(ExpertDto dto) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            CriteriaQuery<Expert> resultCriteria = criteriaBuilder.createQuery(Expert.class);
            Join<Expert, SubService> service = root.join("underService");

            List<Predicate> predicates = new ArrayList<>();
            if (dto.getFullName() != null) {
                predicates.add(criteriaBuilder.in(service.get("name")).value(dto.getSubServiceDtos()));
            }
            if (dto.getEmailAddress() != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), dto.getEmailAddress()));
            }
            if (dto.getCredit() != null) {
                predicates.add(criteriaBuilder.equal(root.get("credit"), dto.getCredit()));
            }
            if (dto.getCredit() != null) {
                predicates.add(criteriaBuilder.equal(root.get("credit"), dto.getCredit()));
            }
            resultCriteria.select(root).where(predicates.toArray(new Predicate[0]));
            return resultCriteria.getRestriction();
        });
    }
}
