package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.QuestionDTO;
import com.upc.talkia_proyect.entities.Question;
import com.upc.talkia_proyect.services.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/question")
    public QuestionDTO insertQuestion(@RequestBody QuestionDTO questionDTO){
        Question question = modelMapper.map(questionDTO, Question.class);
        question = questionService.insertQuestion(question);
        return modelMapper.map(question, QuestionDTO.class);
    }
}
