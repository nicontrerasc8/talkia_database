package com.upc.talkia_proyect.services;

import org.springframework.stereotype.Service;

@Service
public interface RatingService {
    public Integer insertRating(int id_content, int id_user, int rating);
}
