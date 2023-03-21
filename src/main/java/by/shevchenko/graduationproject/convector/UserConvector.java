package by.shevchenko.graduationproject.convector;

import by.shevchenko.graduationproject.dto.UserDto;
import by.shevchenko.graduationproject.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConvector {
    public UserDto convert (UserEntity user){
        UserDto dto = new UserDto();
        dto.setName(user.getUserName());
        return dto;
    }
}
