package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.queries.HistoryByAllDTO;
import com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO;
import com.upc.talkia_proyect.dtos.queries.HistoryByPaymentSuscriptionDTO;
import com.upc.talkia_proyect.dtos.queries.HistoryByUserPaymentDTO;
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
    @GetMapping("/suscriptionHistoryByPaymenyType/{paymentTypeName}")
    public List<HistoryByObjectDTO> listHistoryByPaymentType(@PathVariable String paymentTypeName) {
        return suscriptionHistoryService.listHistoryByPaymentType(paymentTypeName);
    }
    @GetMapping("/suscriptionHistoryByUser/listHistoryByUserSuscription/{userId}/{sName}")
    List<HistoryByObjectDTO> listHistoryByUserAndSuscription(@PathVariable int userId, @PathVariable String sName){
        return suscriptionHistoryService.listHistoryByUserAndSuscription(userId, sName);
    }
    @GetMapping("suscriptionHistories/listHistoryBySuscription/{suscriptionName}")
    public List<HistoryByObjectDTO> listHistoryBySuscription(@PathVariable String suscriptionName) {
        return suscriptionHistoryService.listHistoryBySuscription(suscriptionName);
    }
    @GetMapping("suscriptionHistories/listHistoryByPaymentTypeAndSuscription/{paymentTypeName}/{suscriptionName}")
    public List<HistoryByPaymentSuscriptionDTO> listHistoryByPaymentTypeAndSuscription(@PathVariable String paymentTypeName, @PathVariable String suscriptionName) {
        return suscriptionHistoryService.listHistoryByPaymentTypeAndSuscription(paymentTypeName, suscriptionName);
    }

    @GetMapping("suscriptionHistories/listHistoryByUserAndPayment/{userId}/{paymentTypeName}")
    public List<HistoryByUserPaymentDTO> listHistoryByUserAndPaymentType(@PathVariable int userId, @PathVariable String paymentTypeName) {
        return suscriptionHistoryService.listHistoryByUserAndPaymentType(userId, paymentTypeName);
    }

    @GetMapping("suscriptionHistories/listHistoryByAll/{userId}/{paymentTypeName}/{suscriptionName}")
    public List<HistoryByAllDTO> listHistoryByAllFilters(@PathVariable int userId, @PathVariable String paymentTypeName, @PathVariable String suscriptionName){
        return suscriptionHistoryService.listHistoryByAllFilters(userId, paymentTypeName, suscriptionName);
    }
}
