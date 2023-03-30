package by.shevchenko.graduationproject.config;


import by.shevchenko.graduationproject.jvt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // Можно не писать
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .cors().disable()
                .authorizeRequests((auth) -> auth
                        .requestMatchers("/product/update/","product/delete/","product/").hasRole("ADMIN")
                        .requestMatchers("basket/**").hasRole("USER")
                        .requestMatchers("/registration", "/login", "/swagger-ui/**", "/v3/api-docs/**","product/findAll","product/findById/")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class));
        return httpSecurity.build();
    }
}
