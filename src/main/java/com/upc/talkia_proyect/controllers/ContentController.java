package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.ContentDTO;
import com.upc.talkia_proyect.entities.Content;
import com.upc.talkia_proyect.services.ContentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContentController {
    @Autowired
    private ContentService contentService;

    ModelMapper modelMapper = new ModelMapper();
    @PostMapping("/content")
    public ContentDTO insertContent(@RequestBody ContentDTO contentDTO){
        Content content = modelMapper.map(contentDTO, Content.class);
        content = contentService.insertContent(content);
        return modelMapper.map(content, ContentDTO.class);
    }
}
