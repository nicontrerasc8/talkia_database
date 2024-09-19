package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.repositories.UserRepository;
import com.upc.talkia_proyect.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
