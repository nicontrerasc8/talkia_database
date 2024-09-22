package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.dtos.queries.*;
import com.upc.talkia_proyect.entities.SuscriptionsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SuscriptionHistoryRepository extends JpaRepository<SuscriptionsHistory, Integer> {
    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO(sh.suscription.name, sh.payment.paymentType.name, sh.payment.amount, sh.status, sh.startDate, sh.endDate) " +
            "from SuscriptionsHistory sh where sh.user.id =:userId")
    List<HistoryByObjectDTO> listHistoryByUser(@Param("userId") int userId);

    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO(sh.user.name, sh.suscription.name, sh.payment.amount, sh.status, sh.startDate, sh.endDate)  from SuscriptionsHistory sh where sh.payment.paymentType.name =:paymentTypeName")
    List<HistoryByObjectDTO> listHistoryByPaymentType(@Param("paymentTypeName")String paymentTypeName);

    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO(sh.suscription.name, sh.payment.paymentType.name, sh.payment.amount, sh.status, sh.startDate, sh.endDate)" +
            " from SuscriptionsHistory sh where sh.user.id=:userId and sh.suscription.name=:suscriptionName")
    List<HistoryByObjectDTO> listHistoryByUserAndSuscription(@Param("userId") int userId, @Param("suscriptionName") String suscriptionName);

    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByUserPaymentDTO(sh.payment.amount, sh.suscription.name, sh.status, sh.startDate, sh.endDate)" +
            " from SuscriptionsHistory sh where sh.user.id=:userId and sh.payment.paymentType.name=:paymentTypeName")
    public List<HistoryByUserPaymentDTO> listHistoryByUserAndPaymentType(@Param("userId") int userId, @Param("paymentTypeName")String paymentTypeName);

    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByAllDTO(sh.payment.amount, sh.status, sh.startDate, sh.endDate)" +
            " from SuscriptionsHistory sh where sh.user.id=:userId and sh.payment.paymentType.name=:paymentTypeName and sh.suscription.name=:suscriptionName")
    public List<HistoryByAllDTO> listHistoryByAllFilters(@Param("userId") int userId, @Param("paymentTypeName")String paymentTypeName, @Param("suscriptionName") String suscriptionName);

    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByPaymentSuscriptionDTO(sh.payment.amount, sh.user.name, sh.status, sh.startDate, sh.endDate)" +
            " from SuscriptionsHistory sh where sh.payment.paymentType.name=:paymentTypeName and sh.suscription.name=:suscriptionName")
    public List<HistoryByPaymentSuscriptionDTO> listHistoryByPaymentTypeAndSuscription(@Param("paymentTypeName")String paymentTypeName , @Param("suscriptionName") String suscriptionName);

    @Query("select new com.upc.talkia_proyect.dtos.queries.HistoryByObjectDTO(sh.user.name, sh.payment.paymentType.name," +
            "sh.payment.amount,sh.status, sh.startDate, sh.endDate)" +
            "from SuscriptionsHistory sh where sh.suscription.name =:suscriptionName")
    public List<HistoryByObjectDTO> listHistoryBySuscription(@Param("suscriptionName") String suscriptionName);

    @Query("select new com.upc.talkia_proyect.dtos.queries.TotalAmountBySubTypeDTO(sh.suscription.name,count (sh),sum(sh.payment.amount))" +
            "from SuscriptionsHistory sh where sh.startDate between :startDate and :endDate group by sh.suscription.name")
    List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("select new com.upc.talkia_proyect.dtos.queries.CountHistoriesByObjectDTO" +
            "(sh.payment.paymentType.name ,count(sh)) from SuscriptionsHistory sh group by sh.payment.paymentType.name")
    List<CountHistoriesByObjectDTO> countHistoriesByPaymentType();

    @Query("select new com.upc.talkia_proyect.dtos.queries.CountHistoriesByObjectDTO(sh.suscription.name, count(sh)) from SuscriptionsHistory sh " +
            "where sh.status = 'Activado' group by sh.suscription.name")
    List<CountHistoriesByObjectDTO> countActiveUsersBySubType();

}
