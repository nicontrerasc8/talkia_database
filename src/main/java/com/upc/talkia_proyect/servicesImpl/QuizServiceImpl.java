package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.Quiz;
import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.repositories.QuizRepository;
import com.upc.talkia_proyect.repositories.UserRepository;
import com.upc.talkia_proyect.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Quiz> listQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz insertQuiz(int userId) {
        Quiz quiz = new Quiz();
        User user = userRepository.getUserById(userId);
        quiz.setUser(user);
        quiz.setTotalPoints(0.0);
        quizRepository.save(quiz);
        return quiz;
    }

    @Override
    public List<Quiz> listQuizzesByUserId(int userId) {
        return quizRepository.listQuizzesByUserId(userId);
    }
}
