package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int userId);
}
