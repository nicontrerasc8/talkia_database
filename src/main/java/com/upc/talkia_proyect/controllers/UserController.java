package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.UserDTO;
import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/user")
    public UserDTO insertUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user = userService.insertUser(user);
        return modelMapper.map(user, UserDTO.class);
    }
}
