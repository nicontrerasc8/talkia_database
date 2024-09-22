package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.queries.ShowQuestionsByQuizDTO;
import com.upc.talkia_proyect.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizzesQuestionController {
    @Autowired
    private QuizzesQuestionService qqService;

    @GetMapping("quizzesQuestion/getAveragePointsByUser/{userId}")
    public Double getAveragePoints(@PathVariable int userId) {
        return qqService.getAveragePoints(userId);
    }

    @GetMapping("quizzesQuestion/listTotalQuizzesCompleted/{userId}")
    public Long getTotalQuizzesCompleted(@PathVariable int userId) {
        return qqService.getTotalQuizzesCompleted(userId);
    }
    @GetMapping("quizzesQuestion/getAvgCorrectAnswers/{userId}")
    public Double getAverageCorrectAnswers(@PathVariable int userId){
        return qqService.getAverageCorrectAnswers(userId);
    }

    @PutMapping("/quizzesQuestion/answerQuestion/{qqId}/{userAnswer}")
    public String answerQuestion(@PathVariable int qqId, @PathVariable String userAnswer){
        return qqService.answerQuestion(qqId, userAnswer);
    }

    @GetMapping("quizzesQuestion/getSecondAttemptCorrect/{quizId}")
    public Integer getSecondAttemptCorrectAnswers(@PathVariable int quizId){
        return qqService.getSecondAttemptCorrectAnswers(quizId);
    }
    @GetMapping("quizzesQuestion/getCorrectAnswersCount/{quizId}")
    public Integer getCorrectAnswersCount(@PathVariable int quizId){
        return qqService.getCorrectAnswersCount(quizId);
    }
    @GetMapping("quizzesQuestion/getPercentageCorrectAnswers/{quizId}")
    public Double getPercentageCorrectAnswers(@PathVariable int quizId){
        return qqService.getPercentageCorrectAnswers(quizId);
    }

    @GetMapping("quizzesQuestion/listQuestionsByQuiz/{quizId}")
    public List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(@PathVariable int quizId){
        return qqService.listQuestionsByQuizId(quizId);
    }
}
