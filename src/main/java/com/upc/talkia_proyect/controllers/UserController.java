package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.UserDTO;
import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @DeleteMapping("/user/{id}")
    public void deleteUser(int id){
        userService.deleteUser(id);
    }

    @PostMapping("/user")
    public UserDTO insertUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user = userService.insertUser(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping("/users_exist/{userName}/{password}")
    public boolean existsUser(@PathVariable String userName, @PathVariable String password){
        return userService.existsUser(userName, password);
    }
    @PutMapping("/user")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        ModelMapper modelmapper = new ModelMapper();
        User user = modelmapper.map(userDTO, User.class);
        user = userService.updateUser(user);
        return modelmapper.map(user, UserDTO.class);
    }

    @GetMapping("/users")
    public List<UserDTO> listUsers(){
        List<User>users = userService.listUsers();
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/users_register_date/{startDate}/{endDate}")
    public List<User> listUserByRegisterDate(@PathVariable LocalDate startDate,@PathVariable  LocalDate endDate){
        return userService.listUserByRegisterDate(startDate, endDate);
    }

    @GetMapping("/users_status/{status}")
    public List<User> listUsersByStatus(@PathVariable String status){
        return userService.listUsersByStatus(status);
    }

    @GetMapping("/user_by_username/{username}")
    public User getUserByUserNameContains(@PathVariable String username){
        return  userService.getUserByUserNameContains(username);
    }
    @GetMapping("/user_by_id/{userId}")
    public User getUserById(@PathVariable int userId){
        return userService.getUserById(userId);

    }


}
