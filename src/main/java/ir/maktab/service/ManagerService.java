package ir.maktab.service;

import ir.maktab.dto.ManagerDto;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;

import java.util.Optional;

public interface ManagerService {

    void create(ManagerDto dto);

    void update(ManagerDto dto) throws NotFoundException;

    void remove(ManagerDto dto) throws NotFoundException;

    Optional<ManagerDto> getById(Long id) throws NotFoundException;

    Optional<ManagerDto> login(ManagerDto managerDto) throws NotFoundException, InValidInputException;
}
