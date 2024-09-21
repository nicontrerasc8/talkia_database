package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.AnswerDTO;
import com.upc.talkia_proyect.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkia_proyect.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkia_proyect.entities.Answer;
import com.upc.talkia_proyect.services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/answers/listAnswersByQuestionAdmin")
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(int questionId) {
        return answerService.listAnswerByQuestionAdmin(questionId);
    }

    @GetMapping("/answers/listAnswersByQuestionUser")
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(int questionId) {
        return answerService.listAnswerByQuestionUser(questionId);
    }


}
