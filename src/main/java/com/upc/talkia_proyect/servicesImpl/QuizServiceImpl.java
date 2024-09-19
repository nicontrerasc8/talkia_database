package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.Quiz;
import com.upc.talkia_proyect.repositories.QuizRepository;
import com.upc.talkia_proyect.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> listQuizzes() {
        return quizRepository.findAll();
    }
}
