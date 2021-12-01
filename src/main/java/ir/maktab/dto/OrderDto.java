package ir.maktab.dto;

import ir.maktab.data.enums.OrderState;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {

    private Long id;

    @NotBlank(message = "should not be empty")
    private double proposedPrice;

    private String jobDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "the Order date should not be null")
    private Date orderDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "the done date should not be not null")
    private Date doneDate;

    private String address;

    private OrderState orderState;

    private CustomerDto customerDto;

    private SubServiceDto subServiceDto;


    private List<OfferDto> offerDtos = new ArrayList<>();

    private ExpertDto expertDto;


    public OrderDto() {
    }


    public Long getId() {
        return id;
    }

    public OrderDto setId(Long id) {
        this.id = id;
        return this;
    }

    public double getProposedPrice() {
        return proposedPrice;
    }

    public OrderDto setProposedPrice(double proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public OrderDto setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public OrderDto setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public OrderDto setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public OrderDto setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
        return this;
    }

    public SubServiceDto getSubServiceDto() {
        return subServiceDto;
    }

    public OrderDto setSubServiceDto(SubServiceDto subServiceDto) {
        this.subServiceDto = subServiceDto;
        return this;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public OrderDto setOrderState(OrderState orderState) {
        this.orderState = orderState;
        return this;
    }

    public List<OfferDto> getOfferDtos() {
        return offerDtos;
    }

    public OrderDto setOfferDtos(List<OfferDto> offerDtos) {
        this.offerDtos = offerDtos;
        return this;
    }

    public ExpertDto getExpertDto() {
        return expertDto;
    }

    public OrderDto setExpertDto(ExpertDto expertDto) {
        this.expertDto = expertDto;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                ", proposedPrice=" + proposedPrice +
                ", jobDescription='" + jobDescription + '\'' +
                ", orderDate=" + orderDate +
                ", doneDate=" + doneDate +
                ", address='" + address + '\'' +
                ", orderState=" + orderState +
                ", customerDto=" + customerDto +
                ", subServiceDto=" + subServiceDto +
                ", offerDtos=" + offerDtos +
                ", expertDto=" + expertDto +
                '}';
    }
}
