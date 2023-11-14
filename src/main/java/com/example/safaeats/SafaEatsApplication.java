package com.example.safaeats;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "Bearer Authentication", scheme = "bearer", type = SecuritySchemeType.HTTP, in= SecuritySchemeIn.HEADER, bearerFormat = "JWT")
@OpenAPIDefinition(info = @Info(title = "SAFAEATS - API", version = "1.0", description = "SafaEats Swagger API"))
public class SafaEatsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SafaEatsApplication.class, args);
    }

}
