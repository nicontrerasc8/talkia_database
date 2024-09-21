package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkia_proyect.entities.Payment;

import java.util.List;

public interface PaymentService {
    public List<ShowYearlyPaymentsDTO> listHistories(Integer userId);
    public List<ShowYearlyPaymentsDTO>listHistoriesByYear( Integer userId,  Integer year);
    public List<Payment> listPayments();

}
