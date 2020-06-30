package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.domain.BatchDrink;
import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.domain.enuns.DrinkTypeEnum;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DrinkAlcoholicDTO extends BatchDrinkDTO {

    private Double percentAlcohol;

    public DrinkAlcoholicDTO(BatchDrink dto) {
        super(dto.getId(), dto.getDateTime(), dto.getAmount(), dto.getSession().getId(), dto.getDrinkType().getId());
        this.percentAlcohol = percentAlcohol;
    }
}
