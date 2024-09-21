package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkia_proyect.repositories.PaymentRepository;
import com.upc.talkia_proyect.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<ShowYearlyPaymentsDTO> listHistories(Integer userId) {
        return paymentRepository.listHistories(userId);
    }

    @Override
    public List<ShowYearlyPaymentsDTO> listHistoriesByYear(Integer userId, Integer year) {
        return paymentRepository.listHistoriesByYear(userId, year);
    }
}
