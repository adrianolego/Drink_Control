package com.challange.drinkcontrol.repository;

import com.challange.drinkcontrol.domain.DrinkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkTypeRepository extends JpaRepository<DrinkType, Integer> {
}
