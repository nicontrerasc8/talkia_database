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

    @DeleteMapping("/answer")
    public void deleteAnswer(@RequestBody AnswerDTO answerDTO){
        ModelMapper modelMapper = new ModelMapper();
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answerService.deleteAnswer(answer.getId());
    }

    @PostMapping("/answer")
    public AnswerDTO insertAnswer(@RequestBody AnswerDTO answerDTO){
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer=answerService.insertAnswer(answer);
        return modelMapper.map(answer,AnswerDTO.class);
    }

    @GetMapping("/answers/listAnswersByQuestionAdmin/{questionId}")
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(@PathVariable int questionId) {
        return answerService.listAnswerByQuestionAdmin(questionId);
    }

    @GetMapping("/answers/listAnswersByQuestionUser/{questionId}")
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(@PathVariable int questionId) {
        return answerService.listAnswerByQuestionUser(questionId);
    }
    @PutMapping("/answer")
    public AnswerDTO updateAnswer(@RequestBody AnswerDTO answerDTO){
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer=answerService.updateAnswer(answer);
        return modelMapper.map(answer,AnswerDTO.class);

    }

}
