package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.AnswerDTO;
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
    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/answer")
    public AnswerDTO insertAnswer(@RequestBody AnswerDTO answerDTO){
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer=answerService.insertAnswer(answer);
        return modelMapper.map(answer,AnswerDTO.class);
    }
}
