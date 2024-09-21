package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkia_proyect.services.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserContentController {

    @Autowired
    private UserContentService userContentService;

    @PostMapping("/user_content/{contentId}/{userId}")
    public Integer InsertUserContent(@PathVariable(name="contentId") Integer contentId,
                                     @PathVariable(name = "userId") Integer userId) {
        return userContentService.insertUserContent(contentId, userId);
    }

    @GetMapping("/user_content/listar")
    public List<ShowHistorialContentDTO> listUserContent(){
        return userContentService.listUserContent();
    }
}
