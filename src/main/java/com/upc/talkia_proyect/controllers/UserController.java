package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/user")
    public User insertUser(@RequestBody User user){
        return null;
    }
}
