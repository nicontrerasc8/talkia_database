package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.*;
import com.upc.talkia_proyect.repositories.PaymentTypeRepository;
import com.upc.talkia_proyect.repositories.SuscriptionHistoryRepository;
import com.upc.talkia_proyect.repositories.SuscriptionRepository;
import com.upc.talkia_proyect.repositories.UserRepository;
import com.upc.talkia_proyect.services.SuscriptionHistoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service

public class SuscriptionHistoryServiceImpl implements SuscriptionHistoryService {
    @Autowired
    private SuscriptionHistoryRepository shRepository;

    @Autowired
    private SuscriptionRepository suRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;





    @Override
    @Transactional

    public String insertInManyToManyTable(int userId, int susId, int paymentTypeId) {

        return "Se ha confirmado exitosamente la suscripción al plan ";

    }
}
