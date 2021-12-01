package ir.maktab.dto.mapper;

import ir.maktab.data.entity.SubService;
import ir.maktab.dto.SubServiceDto;

import java.util.List;

public interface SubServiceMapper {

    SubService toSubService(SubServiceDto serviceDto);

    SubServiceDto toSubServiceDto(SubService subService);

    List<SubService> toSubServices(List<SubServiceDto> serviceDto);

    List<SubServiceDto> toSubServiceDtos(List<SubService> subService);
}
