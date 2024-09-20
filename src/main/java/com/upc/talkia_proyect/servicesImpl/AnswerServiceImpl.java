package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.Answer;
import com.upc.talkia_proyect.repositories.AnswerRepository;
import com.upc.talkia_proyect.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    public AnswerRepository answerRepository;
    @Override
    public Answer insertAnswer(Answer answer){
        return answerRepository.save(answer);
    }
}
