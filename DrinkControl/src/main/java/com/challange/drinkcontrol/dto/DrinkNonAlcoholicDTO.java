package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.domain.DrinkBatch;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class DrinkNonAlcoholicDTO extends BatchDrinkDTO {

    public DrinkNonAlcoholicDTO(DrinkBatch dto) {
        super(dto.getId(), dto.getDateTime(),dto.getAmount(), dto.getSession().getId(), dto.getDrinkType().getId());
    }
}
