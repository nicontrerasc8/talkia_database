package com.upc.talkia_proyect.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class HistoryByPaymentSuscriptionDTO {
    private Double amount;
    private String userName;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}