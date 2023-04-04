package by.shevchenko.graduationproject.service;

import by.shevchenko.graduationproject.entity.UserEntity;
import by.shevchenko.graduationproject.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userService.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(login));
        return CustomUserDetails.getUserDetails(user);
    }
}
