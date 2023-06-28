package ru.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class NewSchoolHogwartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewSchoolHogwartsApplication.class, args);
    }

}
