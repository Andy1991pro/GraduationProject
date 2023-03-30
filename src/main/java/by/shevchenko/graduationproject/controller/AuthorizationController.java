package by.shevchenko.graduationproject.controller;


import by.shevchenko.graduationproject.dto.AuthRequest;
import by.shevchenko.graduationproject.dto.AuthResponse;
import by.shevchenko.graduationproject.entity.UserEntity;
import by.shevchenko.graduationproject.jvt.JwtTokenUtil;
import by.shevchenko.graduationproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;




    @PostMapping("registration")
    public void createUser(@RequestBody AuthRequest authRequest) {
        log.error(authRequest.getPassword());
        userService.save(authRequest);
    }

    @PostMapping("login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        UserEntity user = userService.getTokenForUserIfExists(authRequest);
        return new AuthResponse(jwtTokenUtil.generateToken(user.getLogin()));//мы добавили в класс response Allargs... так как без него будет тут ошибка
    }
}