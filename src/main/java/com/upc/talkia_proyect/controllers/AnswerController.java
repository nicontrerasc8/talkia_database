package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.entities.Answer;
import com.upc.talkia_proyect.services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @PostMapping("/answer")
    public Answer insertAnswer(@RequestBody Answer answerDTO){
        return null;
    }
}
