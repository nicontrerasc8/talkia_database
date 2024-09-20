package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.entities.Suscription;
import com.upc.talkia_proyect.services.SuscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuscriptionController {
    @Autowired
    private SuscriptionService suscriptionService;

    @GetMapping("/suscription")
    public List<Suscription> listSuscription(){
        return null;
    }
}
