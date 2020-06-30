package com.challange.drinkcontrol.repository;

import com.challange.drinkcontrol.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    Session findBySessionDescription(String sessionDescription);
}
