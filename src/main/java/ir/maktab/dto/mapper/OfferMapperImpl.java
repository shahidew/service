package ir.maktab.dto.mapper;

import ir.maktab.data.entity.Offer;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.mapper.user.ExpertMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferMapperImpl implements OfferMapper {
    private final ExpertMapper expertMapper;

    public OfferMapperImpl(ExpertMapper expertMapper) {
        this.expertMapper = expertMapper;
    }

    @Override
    public Offer toOffer(OfferDto offerDto) {
        return new Offer()
                .setDateOfRegistration(offerDto.getDateOfRegistration())
                .setDurationOfWork(offerDto.getDurationOfWork())
                .setProposedPrice(offerDto.getProposedPrice())
                .setStartTime(offerDto.getStartTime())
                .setId(offerDto.getId())
                .setExpert(expertMapper.toExpert(offerDto.getExpertDto()))
                .setOfferStatus(offerDto.getOfferStatus());
    }

    @Override
    public OfferDto toOfferDto(Offer offer) {
        return new OfferDto()
                .setDateOfRegistration(offer.getDateOfRegistration())
                .setDurationOfWork(offer.getDurationOfWork())
                .setProposedPrice(offer.getProposedPrice())
                .setStartTime(offer.getStartTime())
                .setOfferStatus(offer.getOfferStatus())
                .setExpertDto(expertMapper.toExpertDto(offer.getExpert()));
    }

    @Override
    public List<Offer> toOffers(List<OfferDto> offerDtos) {
        List<Offer> offers = new ArrayList<>();
        if (offerDtos.isEmpty()) {
            return offers;
        }
        offers = offerDtos.stream().map(this::toOffer).collect(Collectors.toList());
        return offers;
    }

    @Override
    public List<OfferDto> toOfferDtos(List<Offer> offers) {
        List<OfferDto> offerDtos = new ArrayList<>();
        if (offers.isEmpty()) {
            return offerDtos;
        }
        offerDtos = offers.stream().map(this::toOfferDto).collect(Collectors.toList());
        return offerDtos;
    }
}
