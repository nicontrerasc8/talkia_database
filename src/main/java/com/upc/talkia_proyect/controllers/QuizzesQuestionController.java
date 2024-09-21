package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
