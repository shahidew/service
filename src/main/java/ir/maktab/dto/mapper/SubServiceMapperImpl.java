package ir.maktab.dto.mapper;

import ir.maktab.data.entity.SubService;
import ir.maktab.dto.SubServiceDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubServiceMapperImpl implements SubServiceMapper {
    private final SuperServiceMapper superServiceMapper;

    public SubServiceMapperImpl(SuperServiceMapper superServiceMapper) {
        this.superServiceMapper = superServiceMapper;
    }

    @Override
    public SubService toSubService(SubServiceDto subServiceDto) {
        return new SubService().setId(subServiceDto.getId())
                .setBasePrice(subServiceDto.getBasePrice())
                .setName(subServiceDto.getName())
                .setDescription(subServiceDto.getDescription())
               /* .setSuperService(superServiceMapper.toSuperService(subServiceDto.getSuperServiceDto()))*/;
    }

    @Override
    public SubServiceDto toSubServiceDto(SubService subService) {
        return new SubServiceDto().setId(subService.getId())
                .setBasePrice(subService.getBasePrice())
                .setName(subService.getName())
                .setDescription(subService.getDescription())
                /*.setSuperServiceDto(superServiceMapper.toSuperServiceDto(subService.getSuperService()))*/;
    }

    @Override
    public List<SubService> toSubServices(List<SubServiceDto> serviceDtos) {
        List<SubService> subServices = new ArrayList<>();
        if (serviceDtos.isEmpty()) {
            return subServices;
        }
        subServices = serviceDtos.stream().map(this::toSubService).collect(Collectors.toList());
        return subServices;
    }

    @Override
    public List<SubServiceDto> toSubServiceDtos(List<SubService> subServices) {
        List<SubServiceDto> subServiceDtos = new ArrayList<>();
        if (subServices.isEmpty()) {
            return subServiceDtos;
        }
        subServiceDtos = subServices.stream().map(this::toSubServiceDto).collect(Collectors.toList());
        return subServiceDtos;
    }
}
