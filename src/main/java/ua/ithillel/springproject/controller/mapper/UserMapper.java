package ua.ithillel.springproject.controller.mapper;

import org.springframework.stereotype.Component;
import ua.ithillel.springproject.controller.dto.UserDto;
import ua.ithillel.springproject.entity.User;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPhone(),
                user.getAge()
        );
    }

    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getAge()
        );
    }
}
