package com.upc.talkia_proyect.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowContentByFilterDTO {
    private String title;
    private Double avgRating;
    private int year;

}
