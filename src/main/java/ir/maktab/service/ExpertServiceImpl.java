package ir.maktab.service;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.SubService;
import ir.maktab.data.enums.UserState;
import ir.maktab.data.repository.ExpertRepository;
import ir.maktab.data.repository.ExpertSpecifications;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.mapper.SubServiceMapper;
import ir.maktab.dto.mapper.user.ExpertMapper;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpertServiceImpl implements ExpertService {

    private final ExpertMapper mapper;
    private final ExpertRepository repository;
    private final SubServiceMapper subServiceMapper;
    private final ImageFileService imageFileService;
    private final PasswordEncoder passwordEncoder;

    public ExpertServiceImpl(ExpertMapper mapper, ExpertRepository repository, SubServiceMapper subServiceMapper, ImageFileService imageFileService, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.repository = repository;
        this.subServiceMapper = subServiceMapper;
        this.imageFileService = imageFileService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(ExpertDto dto) {
        Expert expert = mapper.toExpert(dto);
        repository.save(expert);
    }

    @Override
    public void update(ExpertDto dto) throws NotFoundException {
        Expert expert = mapper.toExpert(dto);
        if (getExpertById(dto.getId()).isPresent()) {
            repository.save(expert);
        }
    }

    @Override
    public void remove(ExpertDto dto) throws NotFoundException {
        Expert expert = mapper.toExpert(dto);
        if (getExpertById(dto.getId()).isPresent()) {
            repository.delete(expert);
        }
    }

    @Override
    public List<ExpertDto> getAllExpert() throws NotFoundException {
        List<Expert> experts = repository.findAll();
        if (experts.isEmpty()) {
            throw new NotFoundException("not found any expert...");
        } else {
            return mapper.toExpertDtos(experts);
        }
    }

    @Override
    public Optional<ExpertDto> getExpertById(Long id) throws NotFoundException {
        Optional<Expert> expert = repository.findById(id);
        if (!expert.isPresent()) {
            throw new NotFoundException("the expert not found by this Id.");
        }
        ExpertDto expertDto = mapper.toExpertDto(expert.get());
        return Optional.ofNullable(expertDto);
    }


    @Override
    public ExpertDto changePassword(ExpertDto expertDto) {
        Expert expert = mapper.toExpert(expertDto);
       // expert.setPassword(passwordEncoder.encode(expert.getPassword()));
        expert.setPassword(expert.getPassword());
        repository.save(expert);
        return expertDto;
    }


    @Override
    public List<ExpertDto> filterExperts(ExpertDto dto) {
        Pageable pageable = PageRequest.of(dto.getPageNumber(), dto.getPageSize(),
                Sort.by("Id").ascending());
        Specification<Expert> specification = ExpertSpecifications.filterExperts(dto);

        return repository
                .findAll(Specification.where(specification), pageable)
                .stream().map(mapper::toExpertDto).collect(Collectors.toList());

    }

    @Override
    public ExpertDto register(ExpertDto expertDto, MultipartFile image) throws IOException {
        Expert expert = mapper.toExpert(expertDto);
        //expert.setPassword(passwordEncoder.encode(expert.getPassword()));
        expert.setPassword(expert.getPassword());
        expert.setState(UserState.New);
        expert = repository.save(expert);
        imageFileService.uploadImageFile(image, expert);
        return mapper.toExpertDto(expert);
    }

    @Override
    public Optional<ExpertDto> login(String email, String pass) throws NotFoundException {
        Optional<Expert> expertOptional = repository.findExpertByEmailAddressAndPassword(email,pass);
        if (expertOptional.isPresent()) {
            Expert expert = expertOptional.get();
            ExpertDto dto = mapper.toExpertDto(expert);
            return Optional.ofNullable(dto);
        }
        throw new NotFoundException("isn't expert whit this email and pass");
    }

    @Override
    public Optional<ExpertDto> getExpertByEmail(String email) throws InValidInputException {
        Optional<Expert> expert = repository.findExpertByEmailAddress(email);
        if (!expert.isPresent()) {
            throw new InValidInputException("there is no such expert, try again...");
        }
        Expert expert1 = expert.get();
        return Optional.ofNullable(mapper.toExpertDto(expert1));
    }

    @Override
    public void addService(ExpertDto expertDto, SubServiceDto subServiceDto) {
        Expert expert = mapper.toExpert(expertDto);
        SubService subService = subServiceMapper.toSubService(subServiceDto);
        expert.getSubServices().add(subService);
        repository.save(expert);
    }

    @Override
    public ExpertDto findExpertByEmail(String emailAddress) {
        Optional<Expert> expert = repository.findExpertByEmailAddress(emailAddress);
        if (!expert.isPresent()) {
            return null;
            //  throw new InValidInputException("there is no such customer, try again...");
        }
        // return Optional.ofNullable(mapper.toCustomerDto(customer.get()));
        return mapper.toExpertDto(expert.get());
    }
}
