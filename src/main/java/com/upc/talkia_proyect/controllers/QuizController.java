package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.entities.Quiz;
import com.upc.talkia_proyect.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/quizzes")
    public List<Quiz> listQuizzes(){
        return null;
    }
}
