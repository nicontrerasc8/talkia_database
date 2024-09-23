package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.dtos.queries.*;
import com.upc.talkia_proyect.entities.*;
import com.upc.talkia_proyect.repositories.*;
import com.upc.talkia_proyect.services.SuscriptionHistoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class SuscriptionHistoryServiceImpl implements SuscriptionHistoryService {
    @Autowired
    private SuscriptionHistoryRepository shRepository;

    @Autowired
    private SuscriptionRepository suRepository;

    @Autowired
    private UserRepository userRepository;

   @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;





    @Override
    @Transactional

    public String insertInManyToManyTable(int userId, int susId, int paymentTypeId) {
//Ubicar al user
        User user = userRepository.getUserById(userId);
        //Seleccionar suscripcion
        Suscription sus = suRepository.getSuscriptionById(susId);
        //Seleccionar tipo de pago
        PaymentType paymentType = paymentTypeRepository.getPaymentTypeById(paymentTypeId);
        //Crear pago
        Payment payment = new Payment();
        payment.setPaymentType(paymentType);
        payment.setAmount(sus.getPrice());
        payment.setDate(LocalDateTime.now());
        //Insertar pago
        paymentRepository.save(payment);
        //Crear objeto SuscriptionsHistory
        SuscriptionsHistory sh = new SuscriptionsHistory();
        sh.setStartDate(LocalDate.now());
        LocalDate endDate;
        if(sus.getName().equals("Mensual")){
            endDate = LocalDate.now().plusMonths(1);
        }else{
            endDate = LocalDate.now().plusYears(1);
        }
        sh.setEndDate(endDate);
        sh.setStatus("Activado");
        sh.setUser(user);
        sh.setSuscription(sus);
        sh.setPayment(payment);
        shRepository.save(sh);
        return "Se ha confirmado exitosamente la suscripción al plan "  + sus.getName();


    }

    @Override
    public List<HistoryByObjectDTO> listHistoryByUser(int userId) {
        return shRepository.listHistoryByUser(userId);
    }

    @Override
    public List<HistoryByObjectDTO> listHistoryByUserAndSuscription(int userId, String suscriptionName) {
        return shRepository.listHistoryByUserAndSuscription(userId, suscriptionName);
    }
    @Override
    public List<HistoryByObjectDTO> listHistoryByPaymentType(String paymentTypeName) {
        return shRepository.listHistoryByPaymentType(paymentTypeName);
    }
    @Override
    public List<HistoryByObjectDTO> listHistoryBySuscription(String suscriptionName) {
        return shRepository.listHistoryBySuscription(suscriptionName);
    }

    @Override
    public List<HistoryByPaymentSuscriptionDTO> listHistoryByPaymentTypeAndSuscription(String paymentTypeName, String suscriptionName) {
        return shRepository.listHistoryByPaymentTypeAndSuscription(paymentTypeName, suscriptionName);
    }

    @Override
    public List<HistoryByUserPaymentDTO> listHistoryByUserAndPaymentType(int userId, String paymentTypeName) {
        return shRepository.listHistoryByUserAndPaymentType(userId, paymentTypeName);
    }

    @Override
    public List<HistoryByAllDTO> listHistoryByAllFilters(int userId, String paymentTypeName, String suscriptionName){
        return shRepository.listHistoryByAllFilters(userId, paymentTypeName, suscriptionName);
    }

    public List<CountHistoriesByObjectDTO> countHistoriesByPaymentType(LocalDate startDate, LocalDate endDate) {
        return shRepository.countHistoriesByPaymentType(startDate, endDate);
    }

    @Override
    public List<CountHistoriesByObjectDTO> countHistoriesBySubType(LocalDate startDate, LocalDate endDate) {
        return shRepository.countHistoriesBySubType(startDate, endDate);
    }

    @Override
    public List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(LocalDate startDate, LocalDate endDate) {
        return shRepository.listTotalAmountBySubType(startDate, endDate);
    }
}
