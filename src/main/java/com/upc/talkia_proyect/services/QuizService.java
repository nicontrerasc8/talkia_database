package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.entities.Quiz;
import com.upc.talkia_proyect.entities.User;

import java.util.List;

public interface QuizService {
    public List<Quiz> listQuizzes();
    public Quiz insertQuiz(int userId);

}

