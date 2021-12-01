package ir.maktab.data.repository;

import ir.maktab.data.entity.Offer;
import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByDateOfRegistrationAfter(Date dateOfRegistration);

    List<Offer> findAllByDateOfRegistrationBefore(Date dateOfRegistration);

    List<Offer> findUnderServicesByProposedPrice(double proposedPrice);

    List<Offer> findUnderServiceByProposedPriceLessThan(double maxPrice);

    List<Offer> findUnderServiceByProposedPriceGreaterThan(double minPrice);

    Optional<Offer> findOfferByOrder(Order order);

    Optional<Offer> findOfferByExpert(Expert expert);
}
