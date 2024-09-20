package com.upc.talkia_proyect.controllers;
import com.upc.talkia_proyect.entities.Level;
import com.upc.talkia_proyect.services.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LevelController {

    @Autowired
    private LevelService levelService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/levels")
    public List<Level> listLevels(){
        return null;
    }

}
