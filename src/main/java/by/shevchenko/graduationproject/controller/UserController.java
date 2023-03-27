package by.shevchenko.graduationproject.controller;


import by.shevchenko.graduationproject.entity.UserEntity;
import by.shevchenko.graduationproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserEntity save(@RequestBody UserEntity user) {
        return userService.save(user);
    }

}
