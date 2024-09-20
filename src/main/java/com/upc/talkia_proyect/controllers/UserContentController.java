package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.services.UserContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
