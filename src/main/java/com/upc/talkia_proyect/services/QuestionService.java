package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.entities.Question;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {
    public Question insertQuestion(Question question);
}
