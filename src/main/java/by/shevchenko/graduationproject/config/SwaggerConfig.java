package by.shevchenko.graduationproject.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
@SecurityScheme(name = "JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenAPI() {
        return new OpenAPI().info(new Info()
                .summary("Graduation project")
                .description("Online Store")
                .title("REST Online Store app")
                .version("1.0.1")
                .license(new License().name("No license"))
                .contact(new Contact()
                        .name("Andrey Shevcenko")
                        .email("Andy1991pro@gmail.com")));
    }

    @Bean
    public GroupedOpenApi getUserController() {
        return GroupedOpenApi.builder()
                .group("user controller")
                .displayName("user controller")
                .pathsToMatch("/registration", "/login")
                .build();
    }

    @Bean
    public GroupedOpenApi getProductController() {
        return GroupedOpenApi.builder()
                .group("product controller")
                .displayName("product controller")
                .pathsToMatch("/product/**", "/login")
                .build();
    }

    @Bean
    public GroupedOpenApi getBasketController() {
        return GroupedOpenApi.builder()
                .group("basket controller")
                .displayName("basket controller")
                .pathsToMatch("/basket/**", "/login")
                .build();
    }
    @Bean
    public GroupedOpenApi getAdminController() {
        return GroupedOpenApi.builder()
                .group("admin controller")
                .displayName("admin controller")
                .pathsToMatch("/admin", "/login")
                .build();
    }
}
