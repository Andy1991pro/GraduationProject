package by.shevchenko.graduationproject.converter;


import by.shevchenko.graduationproject.dto.UserDto;
import by.shevchenko.graduationproject.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convert(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setLogin(userDto.getLogin());
        user.setPassword(user.getPassword());
        return user;
    }

    public UserDto convert(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }
}
