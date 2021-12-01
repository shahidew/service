package ir.maktab.dto.mapper;

import ir.maktab.data.entity.Offer;
import ir.maktab.dto.OfferDto;

import java.util.List;

public interface OfferMapper {

    Offer toOffer(OfferDto offerDto);

    OfferDto toOfferDto(Offer offer);

    List<Offer> toOffers(List<OfferDto> offerDtos);

    List<OfferDto> toOfferDtos(List<Offer> offers);
}
