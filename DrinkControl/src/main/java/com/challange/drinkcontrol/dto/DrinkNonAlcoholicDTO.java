package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.domain.BatchDrink;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class DrinkNonAlcoholicDTO extends BatchDrinkDTO {

    public DrinkNonAlcoholicDTO(BatchDrink dto) {
        super(dto.getId(), dto.getDateTime(),dto.getAmount(), dto.getSession().getId(), dto.getDrinkType().getId());
    }
}
