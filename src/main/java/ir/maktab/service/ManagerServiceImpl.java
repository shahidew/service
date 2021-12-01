package ir.maktab.service;

import ir.maktab.data.entity.Manager;
import ir.maktab.data.repository.ManagerRepository;
import ir.maktab.dto.ManagerDto;
import ir.maktab.dto.mapper.user.ManagementMapper;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository repository;
    private final ManagementMapper mapper;

    public ManagerServiceImpl(ManagerRepository repository, ManagementMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(ManagerDto dto) {
        Manager manager = mapper.toManagement(dto);
        repository.save(manager);
    }

    @Override
    public void update(ManagerDto dto) throws NotFoundException {
        Manager manager = mapper.toManagement(dto);
        if (getById(dto.getId()).isPresent()) {
            repository.save(manager);
        }
    }

    @Override
    public void remove(ManagerDto dto) throws NotFoundException {
        Manager manager = mapper.toManagement(dto);
        if (getById(dto.getId()).isPresent()) {
            repository.save(manager);
        }
    }

    @Override
    public Optional<ManagerDto> getById(Long id) throws NotFoundException {
        Optional<Manager> manager = repository.findById(id);
        if (!manager.isPresent()) {
            throw new NotFoundException("the manager not found by this Id.");
        }
        ManagerDto managerDto = mapper.toManagementDto(manager.get());
        return Optional.ofNullable(managerDto);
    }

    @Override
    public Optional<ManagerDto> login(ManagerDto managerDto) throws InValidInputException {
        Optional<Manager> manager = repository.findManagerByPasswordAndEmailAddress(managerDto.getPassword(), managerDto.getEmailAddress());
        if (manager.isPresent()) {
            ManagerDto managerDto1 = mapper.toManagementDto(manager.get());
            return Optional.ofNullable(managerDto1);
        } else {
            throw new InValidInputException("there is no such manager, try again..");
        }
    }

}
