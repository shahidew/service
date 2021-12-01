package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.User;
import ir.maktab.dto.UserDto;

import java.util.List;

public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<User> toUsers(List<UserDto> userDto);

    List<UserDto> toUserDtos(List<User> user);
}
