package com.upc.talkia_proyect.dtos;

import com.upc.talkia_proyect.entities.Level;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ContentDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer year;
    private String type;
    private String theme;
    private String link;
    private LocalDateTime iCreatedAt;
    private String iCreatedBy;
    private LocalDateTime iModifiedAt;
    private String iModifiedBy;
    private Set<Level> levels = new HashSet<>();
}
