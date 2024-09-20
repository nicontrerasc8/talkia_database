package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.entities.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContentRepository extends JpaRepository<UserContent, Long> {
}
