package com.upc.talkia_proyect.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "levels_id", nullable = false)
    private Integer id;

    @Column(name = "level", length = 12)
    private String level;

    @Column(name = "i_created_at", updatable = false)
    private LocalDateTime iCreatedAt;


    @PrePersist
    protected void onCreate() {
        iCreatedAt = LocalDateTime.now();

    }



}