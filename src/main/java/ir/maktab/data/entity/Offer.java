package ir.maktab.data.entity;

import ir.maktab.data.enums.OfferStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateOfRegistration;

    @Column
    private Double proposedPrice;

    private Long durationOfWork;

    @Temporal(value = TemporalType.TIME)
    private Date startTime;

    @Enumerated(value = EnumType.STRING)
    private OfferStatus offerStatus;


    @ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL)
    private Order order;


    @ManyToOne(targetEntity = Expert.class , cascade = CascadeType.ALL)
    private Expert expert;


    public Offer() {
    }


    public Long getId() {
        return id;
    }

    public Offer setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public Offer setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

    public Double getProposedPrice() {
        return proposedPrice;
    }

    public Offer setProposedPrice(Double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public Long getDurationOfWork() {
        return durationOfWork;
    }

    public Offer setDurationOfWork(Long durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Offer setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public Offer setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public Offer setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public Offer setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }
}