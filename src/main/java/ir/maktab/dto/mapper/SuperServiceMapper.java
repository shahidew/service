package ir.maktab.dto.mapper;

import ir.maktab.data.entity.SuperService;
import ir.maktab.dto.SuperServiceDto;

import java.util.List;

public interface SuperServiceMapper {

    SuperService toSuperService(SuperServiceDto serviceDto);

    SuperServiceDto toSuperServiceDto(SuperService superService);

    List<SuperService> toSuperServices(List<SuperServiceDto> serviceDto);

    List<SuperServiceDto> toSuperServiceDtos(List<SuperService> superService);
}
