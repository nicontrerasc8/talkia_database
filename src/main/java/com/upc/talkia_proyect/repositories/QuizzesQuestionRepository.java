package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.QuizzesQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzesQuestionRepository extends JpaRepository<QuizzesQuestion, Integer> {
    @Query("select avg(qq.pointsEarned) " +
            "from QuizzesQuestion qq " +
            "where qq.quiz.user.id=:userId")
    public Double getAveragePoints(@Param("userId") int userId);

    @Query("select count(distinct qq.quiz.id) from QuizzesQuestion qq where qq.quiz.user.id=:userId")
    public Long getTotalQuizzesCompleted(@Param("userId") int userId);
    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.user.id = :userId")
    public Long getTotalQuestions(@Param("userId") int userId);

    //total de preguntas correctas
    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.user.id = :userId and qq.is_correct = true")
    public Long getTotalCorrectAnswers(@Param("userId") int userId);

    QuizzesQuestion getQuizzesQuestionById(Integer id);
}
