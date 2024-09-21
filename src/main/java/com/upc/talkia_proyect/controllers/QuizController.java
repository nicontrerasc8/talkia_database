package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.QuizDTO;
import com.upc.talkia_proyect.entities.Quiz;
import com.upc.talkia_proyect.services.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {
    @Autowired
    private QuizService quizService;

    ModelMapper modelMapper=new ModelMapper();

    @GetMapping("/quizzes")
    public List<QuizDTO> listQuizzes(){
        List<Quiz> quizzes =quizService.listQuizzes();
        List<QuizDTO> quizDTOs= modelMapper.map(quizzes,List.class);
        return quizDTOs;
    }

    @PostMapping("/quiz/{userId}")
    public Quiz insertQuiz(@PathVariable int userId){
        return quizService.insertQuiz(userId);
    }

    @GetMapping("/quizzes/{userId}")
    public List<Quiz> listQuizzesByUserId(@PathVariable int userId) {
        return quizService.listQuizzesByUserId(userId);
    }
}
