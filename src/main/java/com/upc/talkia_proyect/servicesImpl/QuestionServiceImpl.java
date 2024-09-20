package com.upc.talkia_proyect.servicesImpl;


import com.upc.talkia_proyect.entities.Question;
import com.upc.talkia_proyect.repositories.QuestionRepository;
import com.upc.talkia_proyect.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public Question insertQuestion(Question question) {
        return questionRepository.save(question);
    }

}
