package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO;

import java.util.List;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
    public List<HistoryByObjectDTO> listHistoryByUser(int userId);

    public List<HistoryByObjectDTO> listHistoryByPaymentType(String paymentTypeName);
    public List<HistoryByObjectDTO> listHistoryByUserAndSuscription(int userId, String suscriptionName);


}
