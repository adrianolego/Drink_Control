package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.domain.DrinkBatch;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class DrinkAlcoholicDTO extends BatchDrinkDTO {

    private Double percentAlcohol;

    public DrinkAlcoholicDTO(DrinkBatch dto) {
        super(dto.getId(), dto.getDateTime(), dto.getAmount(), dto.getSession().getId(), dto.getDrinkType().getId());
        this.percentAlcohol = percentAlcohol;
    }
}
