package ir.maktab.dto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SubServiceDto {
    private Long id;

    @NotNull(message = "the name should not be null")
    private String name;

    @NotNull(message = "the base price should not be null")
    private double basePrice;

    @NotNull(message = "the description should not be null")
    private String description;
    private SuperServiceDto superServiceDto;
    private List<OrderDto> orderDtos = new ArrayList<>();
    private List<ExpertDto> expertDtos = new ArrayList<>();

    public SubServiceDto() {
    }

    public Long getId() {
        return id;
    }

    public SubServiceDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SubServiceDto setName(String name) {
        this.name = name;
        return this;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public SubServiceDto setBasePrice(double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubServiceDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public SuperServiceDto getSuperServiceDto() {
        return superServiceDto;
    }

    public SubServiceDto setSuperServiceDto(SuperServiceDto superServiceDto) {
        this.superServiceDto = superServiceDto;
        return this;
    }

    public List<OrderDto> getOrderDtos() {
        return orderDtos;
    }

    public SubServiceDto setOrderDtos(List<OrderDto> orderDtos) {
        this.orderDtos = orderDtos;
        return this;
    }

    public List<ExpertDto> getExpertDtos() {
        return expertDtos;
    }

    public SubServiceDto setExpertDtos(List<ExpertDto> expertDtos) {
        this.expertDtos = expertDtos;
        return this;
    }

    @Override
    public String toString() {
        return "SubServiceDto{" +
                "  name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                ", superServiceDto=" + superServiceDto +
                ", orderDtos=" + orderDtos +
                ", expertDtos=" + expertDtos +
                '}';
    }
}
