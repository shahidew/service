package ir.maktab.dto;

import ir.maktab.data.enums.OfferStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OfferDto {
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "date of registration should not be null")
    private Date dateOfRegistration;

    @NotNull(message = "proposed price should not be null")
    private double proposedPrice;

    @NotNull(message = "duration of work should not be null")
    private Long durationOfWork;

    @NotNull(message = "start time should not be null")
    @DateTimeFormat(pattern = "00:00:00")
    private Date startTime;

    private OfferStatus offerStatus;

    private OrderDto orderDto;

    private ExpertDto expertDto;


    public Long getId() {
        return id;
    }

    public OfferDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public OfferDto setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

    public double getProposedPrice() {
        return proposedPrice;
    }

    public OfferDto setProposedPrice(double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public Long getDurationOfWork() {
        return durationOfWork;
    }

    public OfferDto setDurationOfWork(Long durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public OfferDto setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public OfferDto setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public OfferDto setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
        return this;
    }

    public ExpertDto getExpertDto() {
        return expertDto;
    }

    public OfferDto setExpertDto(ExpertDto expertDto) {
        this.expertDto = expertDto;
        return this;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                ", dateOfRegistration=" + dateOfRegistration +
                ", proposedPrice=" + proposedPrice +
                ", durationOfWork=" + durationOfWork +
                ", startTime=" + startTime +
                ", offerStatus=" + offerStatus +
                ", orderDto=" + orderDto +
                ", expertDto=" + expertDto +
                '}';
    }
}
