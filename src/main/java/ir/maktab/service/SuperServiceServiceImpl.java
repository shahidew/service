package ir.maktab.service;

import ir.maktab.data.entity.SuperService;
import ir.maktab.data.entity.SubService;
import ir.maktab.data.repository.SuperServiceRepository;
import ir.maktab.dto.mapper.SuperServiceMapper;
import ir.maktab.dto.SuperServiceDto;
import ir.maktab.service.exception.DuplicateException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperServiceServiceImpl implements SuperServiceService {

    private final SuperServiceRepository repository;
    private final SuperServiceMapper mapper;

    @Autowired
    public SuperServiceServiceImpl(SuperServiceRepository repository, SuperServiceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public SuperServiceDto create(SuperServiceDto dto) throws DuplicateException {
        SuperService superService = mapper.toSuperService(dto);
        if (repository.findSuperServiceByName(dto.getName()).isPresent()){
            throw new DuplicateException("the super service already exist");
        }
        repository.save(superService);
        return dto;
    }

    @Override
    public SuperServiceDto update(SuperServiceDto dto) throws NotFoundException {
        SuperService superService = mapper.toSuperService(dto);
        if (!getSuperServiceById(superService.getId()).isPresent()) {
            throw new NotFoundException("the service not found by this id");
        }
        repository.save(superService);
        return dto;
    }


    @Override
    public SuperServiceDto remove(SuperServiceDto dto) throws NotFoundException {
        SuperService superService = mapper.toSuperService(dto);
        if (!getSuperServiceById(superService.getId()).isPresent()) {
            throw new NotFoundException("the service not found by this id");
        }
        repository.delete(superService);
        return dto;
    }

    @Override
    public List<SuperServiceDto> getAllSuperService() throws NotFoundException {
        List<SuperService> superServices = repository.findAll();
        if (superServices.isEmpty()) {
            throw new NotFoundException("not found any super service...");
        } else {
            return mapper.toSuperServiceDtos(superServices);
        }
    }

    @Override
    public Optional<SuperServiceDto> getSuperServiceByName(String name) throws NotFoundException {
        Optional<SuperService> mainService = repository.findSuperServiceByName(name);
        if (!mainService.isPresent()) {
            throw new NotFoundException("the service not found by this name");
        }
        SuperServiceDto superServiceDto = mapper.toSuperServiceDto(mainService.get());
        return Optional.ofNullable(superServiceDto);
    }

    @Override
    public Optional<SuperServiceDto> getSuperServiceById(Long id) throws NotFoundException {
        Optional<SuperService> mainService = repository.findById(id);
        if (!mainService.isPresent()) {
            throw new NotFoundException("the service not found by this id");
        }
        SuperServiceDto superServiceDto = mapper.toSuperServiceDto(mainService.get());
        return Optional.ofNullable(superServiceDto);
    }

    @Override
    public Optional<SuperServiceDto> getSuperServiceBySubServicesIsContaining(SubService subService) throws NotFoundException {
        Optional<SuperService> mainService = repository.findSuperServiceBySubServicesIsContaining(subService);
        if (!mainService.isPresent()) {
            throw new NotFoundException("the service not found by this under service");
        }
        SuperServiceDto superServiceDto = mapper.toSuperServiceDto(mainService.get());
        return Optional.ofNullable(superServiceDto);
    }
}
