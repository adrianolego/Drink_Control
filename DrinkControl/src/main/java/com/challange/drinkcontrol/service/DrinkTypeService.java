package com.challange.drinkcontrol.service;

import com.challange.drinkcontrol.domain.DrinkType;
import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.repository.DrinkTypeRepository;
import com.challange.drinkcontrol.repository.SessionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkTypeService {

    @Autowired
    private DrinkTypeRepository drinkTypeRepository;

    public DrinkType find(Integer id) {
        Optional<DrinkType> drinkType = drinkTypeRepository.findById(id);
        return drinkType.orElseThrow(() -> new ObjectNotFoundException("Drink type not found :Id" + id,
                "Type: " + DrinkType.class.getName()));
    }
}
