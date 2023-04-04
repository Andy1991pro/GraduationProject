package by.shevchenko.graduationproject.controller;


import by.shevchenko.graduationproject.dto.AuthRequest;
import by.shevchenko.graduationproject.dto.AuthResponse;
import by.shevchenko.graduationproject.entity.UserEntity;
import by.shevchenko.graduationproject.jvt.JwtTokenUtil;
import by.shevchenko.graduationproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
@SecurityRequirement(name = "JWT")
@Tag(name = "User controller", description = "Designed for registration of new users and authorization of already registered")
public class AuthorizationController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;


    @Operation(summary = "add new user"
            , description = "method returns nothing"
            , responses = @ApiResponse(responseCode = "200"
            , content = {@Content(mediaType = "application/json"
            , array = @ArraySchema(schema = @Schema(implementation = UserEntity.class)))}))
    @PostMapping("registration")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody AuthRequest authRequest) {
        log.error(authRequest.getPassword());
        userService.save(authRequest);
    }

    @Operation(summary = "authorization user"
            , description = "this method return token"
            , responses = @ApiResponse(responseCode = "200"
            , content = {@Content(mediaType = "application/json"
            , examples = @ExampleObject(value = "{\n" +
            "   \"token\": \"eyJhbGciOiJIUzdfxiJ9.eyJzdWIiOiJBbmR5IiwiZXhwIjoxNjgxNTkyNDAwfQ.qg3TO-xSKCeNh745MIZiyjFzKejIBiBPrfX5CHCWs6db53ycmT5VuMiuj-gs89tKFrIPtjhFIzLkiBVS_x7QVw\"" +
            "}"))}))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        UserEntity user = userService.getTokenForUserIfExists(authRequest);
        return new AuthResponse(jwtTokenUtil.generateToken(user.getLogin()));
    }
}