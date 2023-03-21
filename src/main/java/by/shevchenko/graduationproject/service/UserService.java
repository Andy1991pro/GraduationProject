package by.shevchenko.graduationproject.service;

import by.shevchenko.graduationproject.convector.UserConvector;
import by.shevchenko.graduationproject.dto.UserDto;
import by.shevchenko.graduationproject.entity.UserEntity;
import by.shevchenko.graduationproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

public UserEntity save (UserEntity user){
    return userRepository.save(user);
}

}
