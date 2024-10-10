package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.queries.*;
import com.upc.talkia_proyect.services.SuscriptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @GetMapping("/listHistoryByUserSuscription/{userId}/{sName}")
    List<HistoryByObjectDTO> listHistoryByUserAndSuscription(@PathVariable int userId, @PathVariable String sName){
        return suscriptionHistoryService.listHistoryByUserAndSuscription(userId, sName);
    }
    @GetMapping("/listHistoryBySuscription/{suscriptionName}")
    public List<HistoryByObjectDTO> listHistoryBySuscription(@PathVariable String suscriptionName) {
        return suscriptionHistoryService.listHistoryBySuscription(suscriptionName);
    }
    @GetMapping("/listHistoryByPaymentTypeAndSuscription/{paymentTypeName}/{suscriptionName}")
    public List<HistoryByObjectDTO> listHistoryByPaymentTypeAndSuscription(@PathVariable String paymentTypeName, @PathVariable String suscriptionName) {
        return suscriptionHistoryService.listHistoryByPaymentTypeAndSuscription(paymentTypeName, suscriptionName);
    }

    @GetMapping("/listHistoryByUserAndPayment/{userId}/{paymentTypeName}")
    public List<HistoryByObjectDTO> listHistoryByUserAndPaymentType(@PathVariable int userId, @PathVariable String paymentTypeName) {
        return suscriptionHistoryService.listHistoryByUserAndPaymentType(userId, paymentTypeName);
    }

    @GetMapping("/listHistoryByAll/{userId}/{paymentTypeName}/{suscriptionName}")
    public List<HistoryByObjectDTO> listHistoryByAllFilters(@PathVariable int userId, @PathVariable String paymentTypeName, @PathVariable String suscriptionName){
        return suscriptionHistoryService.listHistoryByAllFilters(userId, paymentTypeName, suscriptionName);
    }

    @GetMapping("/countHistoriesByPaymentType/{startDate}/{endDate}")
    public List<CountHistoriesByObjectDTO> countHistoriesByPaymentType(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        return suscriptionHistoryService.countHistoriesByPaymentType(startDate, endDate);
    }

      @GetMapping("/listTotalAmountBySubType/{startDate}/{endDate}")
    public List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        return suscriptionHistoryService.listTotalAmountBySubType(startDate, endDate);
    }

}
