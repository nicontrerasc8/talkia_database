package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.dtos.queries.HistoryByAllDTO;
import com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO;
import com.upc.talkia_proyect.dtos.queries.HistoryByPaymentSuscriptionDTO;
import com.upc.talkia_proyect.dtos.queries.HistoryByUserPaymentDTO;

import java.util.List;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
    public List<HistoryByObjectDTO> listHistoryByUser(int userId);

    public List<HistoryByObjectDTO> listHistoryByPaymentType(String paymentTypeName);
    public List<HistoryByObjectDTO> listHistoryByUserAndSuscription(int userId, String suscriptionName);
    public List<HistoryByAllDTO> listHistoryByAllFilters(int userId, String paymentTypeName, String suscriptionName);
    public List<HistoryByObjectDTO> listHistoryBySuscription(String suscriptionName);
    public List<HistoryByPaymentSuscriptionDTO> listHistoryByPaymentTypeAndSuscription(String paymentTypeName, String suscriptionName);
    public List<HistoryByUserPaymentDTO> listHistoryByUserAndPaymentType(int userId, String paymentTypeName);


}
