package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    @Query("select q from Quiz q where q.user.id=:userId")
    public List<Quiz> listQuizzesByUserId(@Param("userId") int userId);
}
