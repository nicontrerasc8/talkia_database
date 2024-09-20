package com.upc.talkia_proyect.services;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);

}
