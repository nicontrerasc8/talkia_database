package com.upc.talkia_proyect.services;

public interface QuizzesQuestionService {
    public Double getAveragePoints(int userId);
    public Long getTotalQuizzesCompleted(int userId);
    public Double getAverageCorrectAnswers(int userId);

}
