package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.dtos.queries.ShowRatingByContentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    public Integer insertRating(int id_content, int id_user, int rating);
    public List<ShowRatingByContentDTO> ListContentOrderByScore();
}
