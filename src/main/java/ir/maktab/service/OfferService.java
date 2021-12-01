package ir.maktab.service;

import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.NotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OfferService {

    void create(OfferDto dto, ExpertDto expertDto, OrderDto orderDto);

    void update(OfferDto dto) throws NotFoundException;

    void remove(OfferDto dto) throws NotFoundException;

    List<OfferDto> getAllOffers() throws NotFoundException;

    List<OfferDto> findAllByDateOfRegistrationAfter(Date dateOfRegistration) throws NotFoundException;

    List<OfferDto> findAllByDateOfRegistrationBefore(Date dateOfRegistration) throws NotFoundException;

    List<OfferDto> findUnderServicesByProposedPrice(double proposedPrice) throws NotFoundException;

    List<OfferDto> findUnderServiceByProposedPriceLessThan(double maxPrice) throws NotFoundException;

    List<OfferDto> findUnderServiceByProposedPriceGreaterThan(double minPrice) throws NotFoundException;

    Optional<OfferDto> findOfferByOrder(Order order) throws NotFoundException;

    Optional<OfferDto> findOfferByExpert(Expert expert) throws NotFoundException;
}
