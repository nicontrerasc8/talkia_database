package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.dtos.queries.ShowHistorialContentDTO;
import com.upc.talkia_proyect.entities.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserContentRepository extends JpaRepository<UserContent, Long> {
    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowHistorialContentDTO(uc.user.name, uc.content.title, uc.iViewedAt)" +
            "from UserContent uc")
    List<ShowHistorialContentDTO> listUserContent();
}
