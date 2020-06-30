package com.challange.drinkcontrol.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum DrinkTypeEnum {
    ALCOHOLIC(1, "Alcoholic"),
    NON_ALCOHOLIC(2, "Non alcoholic");

    private Integer code;
    private String description;
}
