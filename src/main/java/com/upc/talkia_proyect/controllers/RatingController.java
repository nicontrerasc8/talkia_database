package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.queries.ShowRatingByContentDTO;
import com.upc.talkia_proyect.services.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/rating/{id_content}/{id_user}/{score}")
    public Integer insertRating(@PathVariable int id_content, @PathVariable int id_user,
                                @PathVariable int score){
        return ratingService.insertRating(id_content, id_user, score);
    }

    @GetMapping("/ratingsContentByScore")
    public List<ShowRatingByContentDTO> ListContentOrderByScore(){
        return ratingService.ListContentOrderByScore();
    }
}
