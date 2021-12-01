package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.User;
import ir.maktab.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(UserDto userDto) {
        return new User()
                .setId(userDto.getId())
                .setEmailAddress(userDto.getEmailAddress())
                .setFullName(userDto.getFullName())
                .setUserRole(userDto.getUserRole())
                .setState(userDto.getState())
                .setPassword(userDto.getPassword())
                .setDate(userDto.getDate())
                .setCredit(userDto.getCredit())
                .setEnabled(userDto.isEnabled());
    }

    @Override
    public UserDto toUserDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setEmailAddress(user.getEmailAddress())
                .setFullName(user.getFullName())
                .setUserRole(user.getUserRole())
                .setState(user.getState())
                .setPassword(user.getPassword())
                .setCredit(user.getCredit())
                .setDate(user.getDate())
                .setEnabled(user.isEnabled());
    }

    @Override
    public List<User> toUsers(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        if (userDtos.isEmpty()) {
            return users;
        }
        users = userDtos.stream().map(this::toUser).collect(Collectors.toList());
        return users;
    }

    @Override
    public List<UserDto> toUserDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        if (users.isEmpty()) {
            return userDtos;
        }
        userDtos = users.stream().map(this::toUserDto).collect(Collectors.toList());
        return userDtos;
    }
}
