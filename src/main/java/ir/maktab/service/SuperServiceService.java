package ir.maktab.service;

import ir.maktab.data.entity.SubService;
import ir.maktab.dto.SuperServiceDto;
import ir.maktab.service.exception.DuplicateException;
import ir.maktab.service.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface SuperServiceService {

    SuperServiceDto create(SuperServiceDto dto) throws DuplicateException;

    SuperServiceDto update(SuperServiceDto dto) throws NotFoundException;

    SuperServiceDto remove(SuperServiceDto dto) throws NotFoundException;

    List<SuperServiceDto> getAllSuperService() throws NotFoundException;

    Optional<SuperServiceDto> getSuperServiceByName(String name) throws NotFoundException;

    Optional<SuperServiceDto> getSuperServiceById(Long id) throws NotFoundException;

    Optional<SuperServiceDto> getSuperServiceBySubServicesIsContaining(SubService subService) throws NotFoundException;

}
