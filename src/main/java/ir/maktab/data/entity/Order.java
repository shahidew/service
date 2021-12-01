package ir.maktab.data.entity;


import ir.maktab.data.enums.OrderState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double proposedPrice;

    @Column
    private String jobDescription;


    @Temporal(value = TemporalType.DATE)
    private Date orderDate;

    @Temporal(value = TemporalType.DATE)
    private Date doneDate;

    @Column
    private String address;

    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(targetEntity = SubService.class,cascade = CascadeType.ALL)
    private SubService subService;


    @OneToMany(mappedBy = "order")
    private List<Offer> offers = new ArrayList<>();

    @ManyToOne(targetEntity = Expert.class, cascade = CascadeType.ALL)
    private Expert expert;


    public Order() {
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public SubService getSubService() {
        return subService;
    }

    public Order setSubService(SubService subService) {
        this.subService = subService;
        return this;
    }

    public double getProposedPrice() {
        return proposedPrice;
    }

    public Order setProposedPrice(double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public Order setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public Order setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public Order setOrderState(OrderState orderState) {
        this.orderState = orderState;
        return this;
    }


    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }


    public List<Offer> getOffers() {
        return offers;
    }

    public Order setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public Expert getExpert() {
        return expert;
    }

    public Order setExpert(Expert expert) {
        this.expert = expert;
        return this;
    }
}
