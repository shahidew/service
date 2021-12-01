package ir.maktab.service;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ExpertService {

    void create(ExpertDto dto);

    void update(ExpertDto dto) throws NotFoundException;

    void remove(ExpertDto dto) throws NotFoundException;

    List<ExpertDto> getAllExpert() throws NotFoundException;

    Optional<ExpertDto> getExpertById(Long id) throws NotFoundException;

    ExpertDto changePassword(ExpertDto expertDto);

    List<ExpertDto> filterExperts(ExpertDto dto);

    ExpertDto register(ExpertDto expertDto, MultipartFile image) throws IOException;

    Optional<ExpertDto> login(String email, String pass) throws NotFoundException;

    Optional<ExpertDto> getExpertByEmail(String email) throws InValidInputException;

    void addService(ExpertDto expertDto, SubServiceDto subServiceDto);

    ExpertDto findExpertByEmail(String emailAddress);
}
