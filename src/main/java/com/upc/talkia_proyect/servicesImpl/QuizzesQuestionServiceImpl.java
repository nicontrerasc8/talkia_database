package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.repositories.QuizzesQuestionRepository;
import com.upc.talkia_proyect.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizzesQuestionServiceImpl implements QuizzesQuestionService {
    @Autowired
    private QuizzesQuestionRepository qqRepository;

    @Override
    public Double getAveragePoints(int userId) {
        return qqRepository.getAveragePoints(userId);
    }

    @Override
    public Long getTotalQuizzesCompleted(int userId) {
        return qqRepository.getTotalQuizzesCompleted(userId);
    }

    @Override
    public Double getAverageCorrectAnswers(int userId) {
        Long totalQuestions = qqRepository.getTotalQuestions(userId);
        Long correctAnswers = qqRepository.getTotalCorrectAnswers(userId);

        if (totalQuestions == 0) {
            return 0.0;
        }
        return correctAnswers * 1.0 / totalQuestions;
    }


}
