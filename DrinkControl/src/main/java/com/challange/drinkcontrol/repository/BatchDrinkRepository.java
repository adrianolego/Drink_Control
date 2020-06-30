package com.challange.drinkcontrol.repository;

import com.challange.drinkcontrol.domain.BatchDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchDrinkRepository extends JpaRepository<BatchDrink, Integer> {
}
