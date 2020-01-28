package com.example.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.example.todos"})
@EnableJpaRepositories(basePackages = {"com.example.todos"})
@SpringBootApplication(scanBasePackages = {"com.example.todos"})
public class BackTodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackTodosApplication.class, args);
    }

}
