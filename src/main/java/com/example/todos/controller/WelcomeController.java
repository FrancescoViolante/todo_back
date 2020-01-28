package com.example.todos.controller;


import com.example.todos.model.WelcomeBean;
import com.example.todos.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @Autowired
    private WelcomeService welcomeService;

    @GetMapping
    public WelcomeBean welcomeCustomize() {

        return new WelcomeBean("Welcome in this amazing Application");
        //  throw  new RuntimeException("Some Error has happened! Contact the support");
    }

    @GetMapping(path = "/pathVariable/{name}")
    public WelcomeBean welcomeCustomizePathVariable(@PathVariable String name) {

        return new WelcomeBean(String.format("Welcome in this amazing Application, %s", name));

    }

}
