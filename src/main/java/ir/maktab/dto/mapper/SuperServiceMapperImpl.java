package ir.maktab.dto.mapper;

import ir.maktab.data.entity.SuperService;
import ir.maktab.dto.SuperServiceDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuperServiceMapperImpl implements SuperServiceMapper {


    @Override
    public SuperService toSuperService(SuperServiceDto serviceDto) {
        return new SuperService()
                .setName(serviceDto.getName())
                .setId(serviceDto.getId());
    }

    @Override
    public SuperServiceDto toSuperServiceDto(SuperService superService) {
        return new SuperServiceDto()
                .setName(superService.getName())
                .setId(superService.getId());
    }

    @Override
    public List<SuperService> toSuperServices(List<SuperServiceDto> serviceDtos) {
        List<SuperService> superServices = new ArrayList<>();
        if (serviceDtos.isEmpty()) {
            return superServices;
        }
        superServices = serviceDtos.stream().map(this::toSuperService).collect(Collectors.toList());
        return superServices;
    }

    @Override
    public List<SuperServiceDto> toSuperServiceDtos(List<SuperService> superServices) {
        List<SuperServiceDto> serviceDtos = new ArrayList<>();
        if (superServices.isEmpty()) {
            return serviceDtos;
        }
        serviceDtos = superServices.stream().map(this::toSuperServiceDto).collect(Collectors.toList());
        return serviceDtos;
    }
}
