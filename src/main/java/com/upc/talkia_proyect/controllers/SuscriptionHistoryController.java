package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.services.SuscriptionHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SuscriptionHistoryController {
    @Autowired
    private SuscriptionHistoryService suscriptionHistoryService;



    @PostMapping("/suscriptionHistory/{user_id}/{sus_id}/{paymentType_id}")
    public String insertInManyToManyTable(@PathVariable int user_id, @PathVariable int sus_id, @PathVariable int paymentType_id){
        return suscriptionHistoryService.insertInManyToManyTable(user_id, sus_id, paymentType_id);
    }

}
