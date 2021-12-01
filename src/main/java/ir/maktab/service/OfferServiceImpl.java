package ir.maktab.service;

import ir.maktab.data.entity.Offer;
import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.enums.OfferStatus;
import ir.maktab.data.repository.OfferRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.dto.mapper.OfferMapper;
import ir.maktab.dto.mapper.OrderMapper;
import ir.maktab.dto.mapper.user.ExpertMapper;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repository;
    private final OfferMapper mapper;
    private final ExpertMapper expertMapper;
    private final OrderMapper orderMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository repository, OfferMapper mapper, ExpertMapper expertMapper, OrderMapper orderMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.expertMapper = expertMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public void create(OfferDto dto, ExpertDto expertDto, OrderDto orderDto) {
        Offer offer = mapper.toOffer(dto);
        Expert expert = expertMapper.toExpert(expertDto);
        Order order = orderMapper.toOrder(orderDto);
        offer.setOfferStatus(OfferStatus.REGISTERED);
        repository.save(offer);
        offer.setExpert(expert);
        offer.setOrder(order);
        expert.getOffers().add(offer);
        expert.getOrders().add(order);
        repository.save(offer);
    }

    @Override
    public void update(OfferDto dto) throws NotFoundException {
        Offer offer = mapper.toOffer(dto);
        if (repository.findById(dto.getId()).isPresent()) {
            repository.save(offer);
        } else {
            throw new NotFoundException("The offer not found!");
        }
    }

    @Override
    public void remove(OfferDto dto) throws NotFoundException {
        Offer offer = mapper.toOffer(dto);
        if (repository.findById(dto.getId()).isPresent()) {
            repository.delete(offer);
        } else {
            throw new NotFoundException("The offer not found!");
        }
    }

    //TODO
    @Override
    public List<OfferDto> getAllOffers() throws NotFoundException {
        List<Offer> offers = repository.findAll();
        if (offers.isEmpty()) {
            throw new NotFoundException("not found any Offer...");
        } else {
            return mapper.toOfferDtos(offers);
        }
    }

    @Override
    public List<OfferDto> findAllByDateOfRegistrationAfter(Date dateOfRegistration) throws NotFoundException {
        List<Offer> offers = repository.findAllByDateOfRegistrationAfter(dateOfRegistration);
        if (offers.isEmpty()) {
            throw new NotFoundException("not found any Offer after this date...");
        } else {
            return mapper.toOfferDtos(offers);
        }
    }

    @Override
    public List<OfferDto> findAllByDateOfRegistrationBefore(Date dateOfRegistration) throws NotFoundException {
        List<Offer> offers = repository.findAllByDateOfRegistrationBefore(dateOfRegistration);
        if (offers.isEmpty()) {
            throw new NotFoundException("not found any Offer before this date...");
        } else {
            return mapper.toOfferDtos(offers);
        }
    }

    @Override
    public List<OfferDto> findUnderServicesByProposedPrice(double proposedPrice) throws NotFoundException {
        List<Offer> offers = repository.findUnderServicesByProposedPrice(proposedPrice);
        if (offers.isEmpty()) {
            throw new NotFoundException("not found any Offer by this proposed price...");
        } else {
            return mapper.toOfferDtos(offers);
        }
    }

    @Override
    public List<OfferDto> findUnderServiceByProposedPriceLessThan(double maxPrice) throws NotFoundException {
        List<Offer> offers = repository.findUnderServiceByProposedPriceLessThan(maxPrice);
        if (offers.isEmpty()) {
            throw new NotFoundException("not found any Offer less than this price...");
        } else {
            return mapper.toOfferDtos(offers);
        }
    }

    @Override
    public List<OfferDto> findUnderServiceByProposedPriceGreaterThan(double minPrice) throws NotFoundException {
        List<Offer> offers = repository.findUnderServiceByProposedPriceGreaterThan(minPrice);
        if (offers.isEmpty()) {
            throw new NotFoundException("not found any Offer greater than this price...");
        } else {
            return mapper.toOfferDtos(offers);
        }
    }

    @Override
    public Optional<OfferDto> findOfferByOrder(Order order) throws NotFoundException {
        // sort by price and score
        Optional<Offer> offer = repository.findOfferByOrder(order);
        if (!offer.isPresent()) {
            throw new NotFoundException("the offer not found by this order.");
        }
        OfferDto offerDto = mapper.toOfferDto(offer.get());
        return Optional.ofNullable(offerDto);
    }

    @Override
    public Optional<OfferDto> findOfferByExpert(Expert expert) throws NotFoundException {
        Optional<Offer> offer = repository.findOfferByExpert(expert);
        if (!offer.isPresent()) {
            throw new NotFoundException("the offer not found by this expert.");
        }
        OfferDto offerDto = mapper.toOfferDto(offer.get());
        return Optional.ofNullable(offerDto);
    }
}
