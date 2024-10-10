package com.upc.talkia_proyect.controllers;

import com.upc.talkia_proyect.dtos.PaymentDTO;
import com.upc.talkia_proyect.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkia_proyect.entities.Payment;
import com.upc.talkia_proyect.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")

public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/paymentsbyyear/{userId}")
    public List<ShowYearlyPaymentsDTO> listPaymentsByUser(@PathVariable Integer userId){
        return paymentService.listPaymentsByUser(userId);
    }
    @GetMapping("/paymentbyyear/{userId}/{year}")

    public List<ShowYearlyPaymentsDTO>listPaymentsByYear( @PathVariable Integer userId, @PathVariable Integer year) {
        return paymentService.listPaymentsByYear(userId, year);
    }
    @GetMapping("/payments")
    public List<PaymentDTO> listPayments(){
        List<Payment> list = paymentService.listPayments();
        List<PaymentDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }





}
