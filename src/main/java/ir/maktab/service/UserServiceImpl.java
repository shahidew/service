package ir.maktab.service;

import ir.maktab.data.entity.User;
import ir.maktab.data.enums.UserRole;
import ir.maktab.data.repository.UserRepository;
import ir.maktab.data.repository.UserSpecifications;
import ir.maktab.dto.FilterUserDto;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.mapper.user.UserMapper;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDto create(UserDto dto) {
        User user = mapper.toUser(dto);
        repository.save(user);
        return dto;
    }

    @Override
    public void update(UserDto dto) throws NotFoundException {
        User user = mapper.toUser(dto);
        if (!getUserById(dto.getId()).isPresent()) {
            repository.save(user);
        }
    }

    @Override
    public void remove(UserDto dto) throws NotFoundException {
        User user = mapper.toUser(dto);
        if (!getUserById(dto.getId()).isPresent()) {
            repository.delete(user);
        }
    }


    @Override
    public List<UserDto> getAllUser() throws NotFoundException {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("not found any user...");
        } else {
            return mapper.toUserDtos(users);
        }
    }

    @Override
    public Optional<UserDto> getUserByFullName(String fullName) throws NotFoundException {
        Optional<User> user = repository.findUserByFullName(fullName);
        if (!user.isPresent()) {
            throw new NotFoundException("the user not found by this name.");
        }
        UserDto userDto = mapper.toUserDto(user.get());
        return Optional.ofNullable(userDto);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) throws NotFoundException {
        Optional<User> user = repository.findUserByEmailAddress(email);
        if (!user.isPresent()) {
            throw new NotFoundException("the user not found by this email.");
        }
        UserDto userDto = mapper.toUserDto(user.get());
        return Optional.ofNullable(userDto);
    }

    @Override
    public Optional<UserDto> getUserById(Long id) throws NotFoundException {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException("the user not found by this Id.");
        }
        UserDto userDto = mapper.toUserDto(user.get());
        return Optional.ofNullable(userDto);
    }

    @Override
    public List<UserDto> getUserByRole(UserRole role) throws NotFoundException {
        List<User> users = repository.findUserByUserRole(role);
        if (users.isEmpty()) {
            throw new NotFoundException("not found any user by this user role...");
        } else {
            return mapper.toUserDtos(users);
        }
    }

    @Override
    public Optional<UserDto> getUserByPassword(String password) throws NotFoundException {
        Optional<User> user = repository.findUserByPassword(password);
        if (!user.isPresent()) {
            throw new NotFoundException("the user not found by this password.");
        }
        UserDto userDto = mapper.toUserDto(user.get());
        return Optional.ofNullable(userDto);
    }

    @Override
    public List<UserDto> filterUsers(FilterUserDto dto) {
        Pageable pageable = PageRequest.of(dto.getPageNumber(), dto.getPageSize(), Sort.by("id").descending());
        Specification<User> specification = UserSpecifications.filterUsers(dto);
        List<UserDto> resultList = repository
                .findAll(Specification.where
                        (specification),pageable)
                .stream().map(mapper::toUserDto)
                .collect(Collectors.toList());
        return resultList;
    }



}
