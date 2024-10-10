package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.UserDTO;
import com.upc.talkia_proyect.dtos.queries.ShowSuscriptionDetailsDTO;
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
    public void deleteUser(@PathVariable int id){
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
        User user = modelMapper.map(userDTO, User.class);
        user = userService.updateUser(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping("/users")
    public List<UserDTO> listUsers(){
        List<User>users = userService.listUsers();
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/users_register_date/{startDate}/{endDate}")
    public List<UserDTO> listUsersByRegisterDate(@PathVariable LocalDate startDate,@PathVariable  LocalDate endDate){
        List<User>users = userService.listUsersByRegisterDate(startDate, endDate);
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/users_status/{status}")
    public List<UserDTO> listUsersByStatus(@PathVariable String status){
        List<User>users =  userService.listUsersByStatus(status);
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/user_by_username/{username}")
    public  List<UserDTO> getUserByUserNameContains(@PathVariable String username){
        List<User>users =  userService.getUserByUserNameContains(username);
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }
    @GetMapping("/user_by_id/{userId}")
    public User getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/current_suscription_by_user_id/{userId}")
    public ShowSuscriptionDetailsDTO getCurrentSuscription(@PathVariable int userId){
        return userService.getCurrentSuscription(userId);
    }


}
