package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.Level;
import com.upc.talkia_proyect.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> getQuestionsByLevel(Level level);

}
