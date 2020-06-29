package com.challange.drinkcontrol.repository;

import com.challange.drinkcontrol.domain.Drink;
import com.challange.drinkcontrol.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
