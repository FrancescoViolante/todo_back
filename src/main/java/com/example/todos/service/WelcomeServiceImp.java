package com.example.todos.service;


import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImp implements WelcomeService {

    @Override
    public String getWelcomeCustomize() {
        return "Welcome in this amazing Application, Francesco";
    }
}
