package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.repositories.UserRepository;
import com.upc.talkia_proyect.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }


    @Override
    @Transactional
    public boolean existsUser(String userName, String password){
        for(User user: listUsers()) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
