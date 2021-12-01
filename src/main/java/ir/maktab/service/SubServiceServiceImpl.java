package ir.maktab.service;

import ir.maktab.data.entity.Order;
import ir.maktab.data.entity.SubService;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.SuperService;
import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SuperServiceDto;
import ir.maktab.dto.mapper.SubServiceMapper;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.mapper.SuperServiceMapper;
import ir.maktab.dto.mapper.user.ExpertMapper;
import ir.maktab.service.exception.DuplicateException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceMapper mapper;
    private final SubServiceRepository repository;
    private final SuperServiceMapper superServiceMapper;
    private final ExpertMapper expertMapper;

    @Autowired
    public SubServiceServiceImpl(SubServiceMapper mapper, SubServiceRepository repository, SuperServiceMapper superServiceMapper, ExpertMapper expertMapper) {
        this.mapper = mapper;
        this.repository = repository;
        this.superServiceMapper = superServiceMapper;
        this.expertMapper = expertMapper;
    }


    @Override
    public SubServiceDto create(SubServiceDto dto, SuperServiceDto superServiceDto) throws DuplicateException {
        SubService subService = mapper.toSubService(dto);
        if (repository.findSubServiceByName(dto.getName()).isPresent()){
            throw new DuplicateException("the subService exist already by this name");
        }
        repository.save(subService);
        SuperService superService = superServiceMapper.toSuperService(superServiceDto);
        subService.setSuperService(superService);
        repository.save(subService);
        return dto;
    }

    @Override
    public void update(SubServiceDto dto) throws NotFoundException {
        SubService subService = mapper.toSubService(dto);
        if (!getSubServiceById(subService.getId()).isPresent()) {
            repository.save(subService);
        }
    }

    @Override
    public void remove(SubServiceDto dto) throws NotFoundException {
        SubService subService = mapper.toSubService(dto);
        if (!getSubServiceById(subService.getId()).isPresent()) {
            repository.delete(subService);
        }
    }

    @Override
    public List<SubServiceDto> getAllSubService() throws NotFoundException {
        List<SubService> subServices = repository.findAll();
        if (subServices.isEmpty()) {
            throw new NotFoundException("not found any Sub service...");
        }
        return mapper.toSubServiceDtos(subServices);

    }

    @Override
    public Optional<SubServiceDto> getSubServiceById(Long id) throws NotFoundException {
        Optional<SubService> underService = repository.findById(id);
        if (!underService.isPresent()) {
            throw new NotFoundException("the service not found by this name");
        }
        SubService subService1 = underService.get();
        SubServiceDto subServiceDto = mapper.toSubServiceDto(subService1);
        return Optional.ofNullable(subServiceDto);
    }

    @Override
    public Optional<SubServiceDto> getSubServiceByName(String name) throws NotFoundException {
        Optional<SubService> underService = repository.findSubServiceByName(name);
        if (!underService.isPresent()) {
            throw new NotFoundException("the service not found by this name");
        }
        SubService subService1 = underService.get();
        SubServiceDto subServiceDto = mapper.toSubServiceDto(subService1);
        return Optional.ofNullable(subServiceDto);
    }

    @Override
    public List<SubServiceDto> getSubServiceByBasePrice(double basePrice) throws NotFoundException {
        List<SubService> subServices = repository.findSubServiceByBasePrice(basePrice);
        if (subServices.isEmpty()) {
            throw new NotFoundException("not found any sub service by this base price...");
        } else {
            return mapper.toSubServiceDtos(subServices);
        }
    }


    @Override
    public List<SubServiceDto> getSubServiceByExpertsContains(Expert expert) throws NotFoundException {
        List<SubService> subServices = repository.findSubServiceByExpertsContains(expert);
        if (subServices.isEmpty()) {
            throw new NotFoundException("not found any under service by this expert...");
        } else {
            return mapper.toSubServiceDtos(subServices);
        }
    }

    @Override
    public List<SubServiceDto> getSubServiceByOrdersContains(Order order) throws NotFoundException {
        List<SubService> subServices = repository.findSubServiceByOrdersContains(order);
        if (subServices.isEmpty()) {
            throw new NotFoundException("not found any under service by this order...");
        } else {
            return mapper.toSubServiceDtos(subServices);
        }
    }

    @Override
    public void addExperts(SubServiceDto subServiceDto, ExpertDto expertDto) {
        SubService subService = mapper.toSubService(subServiceDto);
        Expert expert = expertMapper.toExpert(expertDto);
        subService.getExperts().add(expert);
        repository.save(subService);
    }


}
