package ir.maktab.dto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SuperServiceDto {

    private Long id;

    @NotNull(message = "the name should not be null")
    private String name;
    private List<SubServiceDto> subServiceDtos = new ArrayList<>();


    public SuperServiceDto() {
    }

    public Long getId() {
        return id;
    }

    public SuperServiceDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SuperServiceDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<SubServiceDto> getSubServiceDtos() {
        return subServiceDtos;
    }

    public SuperServiceDto setSubServiceDtos(List<SubServiceDto> subServiceDtos) {
        this.subServiceDtos = subServiceDtos;
        return this;
    }

    @Override
    public String toString() {
        return "SuperServiceDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
