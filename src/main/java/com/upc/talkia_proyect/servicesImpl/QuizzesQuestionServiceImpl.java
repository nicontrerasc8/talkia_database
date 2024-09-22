package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.Question;
import com.upc.talkia_proyect.entities.QuizzesQuestion;
import com.upc.talkia_proyect.entities.User;
import com.upc.talkia_proyect.repositories.AnswerRepository;
import com.upc.talkia_proyect.repositories.QuizzesQuestionRepository;
import com.upc.talkia_proyect.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizzesQuestionServiceImpl implements QuizzesQuestionService {
    @Autowired
    private QuizzesQuestionRepository qqRepository;

    @Autowired
    private AnswerRepository answerRepository;


    List<Double> pointsByLevel = Arrays.asList(10.0, 20.0, 30.0);

    @Override
    @Transactional
    public String answerQuestion(int qqId, String userAnswer) {
        QuizzesQuestion qq = qqRepository.getQuizzesQuestionById(qqId);
        Question question = qq.getQuestion();
        Double points = qq.getPointsEarned();
        Double pointsQuiz = qq.getQuiz().getTotalPoints();
        Double pointsUser = qq.getQuiz().getUser().getTotalPoints();

        if(qq.getAttempt()<2 && !qq.getIs_correct()){
            qq.setUserAnswer(userAnswer);
            qq.setAttempt(qq.getAttempt() + 1);

            if(answerRepository.getCorrectAnswerByQuestionId(question.getId()).getDescription().equals(userAnswer)) {
                if (qq.getAttempt() == 1) {
                    double gainedPoints = pointsByLevel.get(question.getLevel().getId()-1);
                    points += gainedPoints;
                    qq.setPointsEarned(points);
                    qq.setIs_correct(true);
                    pointsQuiz += qq.getPointsEarned();
                    qq.getQuiz().setTotalPoints(pointsQuiz);
                    return "Correct!, haz ganado "+ gainedPoints+" puntos";

                }
                if(qq.getAttempt()== 2){
                    double compensatePoints = (pointsByLevel.get(question.getLevel().getId()-1))/(2.0);
                    points += compensatePoints;
                    qq.setPointsEarned(points);
                    qq.setIs_correct(true);
                    pointsQuiz += qq.getPointsEarned();
                    qq.getQuiz().setTotalPoints(pointsQuiz);
                    pointsUser += pointsQuiz;

                    return "Now is correct!, haz ganado "+ compensatePoints+" puntos";
                }


            }
            return "Incorrect. "+ question.getFeedback();
        }
        return "Has llegado al límite de intentos permitidos";

    }



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

    @Override
    public Integer getSecondAttemptCorrectAnswers(int quizId) {
        return qqRepository.getSecondAttemptCorrectAnswers(quizId);
    }

    @Override
    public Integer getCorrectAnswersCount(int quizId) {
        return qqRepository.getCorrectAnswersCount(quizId);
    }

    @Override
    public Double getPercentageCorrectAnswers(int quizId) {
        double correctAnswers = 1.0 * qqRepository.getCorrectAnswersCount(quizId);

        return correctAnswers/4.0;
    }



}
