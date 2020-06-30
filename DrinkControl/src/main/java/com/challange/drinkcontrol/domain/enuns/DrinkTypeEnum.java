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

    public static DrinkTypeEnum toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (DrinkTypeEnum dt : DrinkTypeEnum.values()) {
            if (code.equals(dt.getCode())) {
                return dt;
            }
        }

        throw new IllegalArgumentException("Invalid Id: " + code);
    }
}
