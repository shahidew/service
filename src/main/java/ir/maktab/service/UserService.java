package ir.maktab.service;

import ir.maktab.data.enums.UserRole;
import ir.maktab.dto.FilterUserDto;
import ir.maktab.dto.UserDto;
import ir.maktab.service.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto create(UserDto dto);

    void update(UserDto dto) throws NotFoundException;

    void remove(UserDto dto) throws NotFoundException;

    List<UserDto> getAllUser() throws NotFoundException;

    Optional<UserDto> getUserByFullName(String fullName) throws NotFoundException;

    Optional<UserDto> getUserByEmail(String email) throws NotFoundException;

    Optional<UserDto> getUserById(Long id) throws NotFoundException;

    List<UserDto> getUserByRole(UserRole role) throws NotFoundException;

    Optional<UserDto> getUserByPassword(String password) throws NotFoundException;

    List<UserDto> filterUsers(FilterUserDto dto);
}
