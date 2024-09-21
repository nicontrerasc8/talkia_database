package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    public User insertUser(User user);
    public User getUserById(int userId);
    public List<User> listUsers();
    public boolean existsUser(String userName, String password);
    public List<User> listUserByRegisterDate(LocalDate startDate, LocalDate endDate);
    public List<User> listUsersByStatus(String status);
    public User getUserByUserNameContains(String username);
}
