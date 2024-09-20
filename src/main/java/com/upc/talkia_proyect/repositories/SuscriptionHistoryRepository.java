package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.SuscriptionsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptionHistoryRepository extends JpaRepository<SuscriptionsHistory, Integer> {
}
