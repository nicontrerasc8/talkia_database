package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO;

import java.util.List;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
    public List<HistoryByObjectDTO> listHistoryByUser(int userId);
}
