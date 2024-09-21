package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int userId);
    @Query("select u from User u where u.iCreatedAt between :startDate and :endDate")
    List<User> listUsersByRegisterDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    @Query("select sh.user from SuscriptionsHistory sh where sh.status =:status")
    List<User> listUsersByStatus(@Param("status")String status);
}
