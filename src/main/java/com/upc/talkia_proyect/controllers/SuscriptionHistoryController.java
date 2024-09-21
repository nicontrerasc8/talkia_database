package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO;
import com.upc.talkia_proyect.services.SuscriptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuscriptionHistoryController {

    @Autowired
    private SuscriptionHistoryService suscriptionHistoryService;

    @PostMapping("/suscriptionHistory/{user_id}/{sus_id}/{paymentType_id}")
    public String insertInManyToManyTable(@PathVariable int user_id, @PathVariable int sus_id, @PathVariable int paymentType_id){
        return suscriptionHistoryService.insertInManyToManyTable(user_id, sus_id, paymentType_id);
    }

    @GetMapping("/suscriptionHistoryByUser/{userId}")
    public List<HistoryByObjectDTO> listHistoryByUser(@PathVariable int userId){
        return suscriptionHistoryService.listHistoryByUser(userId);
    }
}
