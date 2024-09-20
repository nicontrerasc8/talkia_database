package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.entities.Content;
import com.upc.talkia_proyect.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @PostMapping("/content")
    public Content insertContent(Content content){
        return null;
    }
}
