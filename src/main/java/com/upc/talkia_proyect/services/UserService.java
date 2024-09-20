package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.entities.User;

import java.util.List;

public interface UserService {
    public User insertUser(User user);
    public List<User> listUsers();


    public boolean existsUser(String userName, String password);
}
