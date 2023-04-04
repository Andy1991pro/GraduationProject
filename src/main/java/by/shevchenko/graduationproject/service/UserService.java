package by.shevchenko.graduationproject.service;

import by.shevchenko.graduationproject.converter.UserConverter;
import by.shevchenko.graduationproject.dto.AuthRequest;
import by.shevchenko.graduationproject.dto.UserDto;
import by.shevchenko.graduationproject.entity.BasketEntity;
import by.shevchenko.graduationproject.entity.RoleEntity;
import by.shevchenko.graduationproject.entity.UserEntity;
import by.shevchenko.graduationproject.repository.RoleRepository;
import by.shevchenko.graduationproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserConverter converter;
    private final BCryptPasswordEncoder passwordEncoder;

    public void save(AuthRequest request) {
        UserDto userDto = new UserDto();
        userDto.setRoleId(1L);
        userDto.setLogin(request.getLogin());
        userDto.setPassword(request.getPassword());
        save(userDto);
    }

    public UserDto save(UserDto userDto) {
        log.error(userDto.getPassword());
        long roleId = userDto.getRoleId();
        RoleEntity role = roleRepository.findById(roleId).orElseThrow();
        UserEntity user = converter.convert(userDto);
        BasketEntity basket = new BasketEntity();
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setBasket(basket);
        userRepository.save(user);
        log.error(user.getPassword());
        return converter.convert(user);
    }

    public Optional<UserEntity> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public UserEntity getTokenForUserIfExists(AuthRequest authRequest) {
        return findByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword()).orElseThrow();
    }

    public Optional<UserEntity> findByLoginAndPassword(String login, String password) {
        UserEntity user = findByLogin(login).orElseThrow();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

}
