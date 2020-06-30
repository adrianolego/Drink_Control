package com.challange.drinkcontrol.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonTypeName("alcoholic")
public class DrinkAlcoholic extends BatchDrink {

    private Double percentAlcohol;

    @Builder
    public DrinkAlcoholic(Integer id, LocalDateTime dateTime,
                          Integer amount, Session session,
                          Double percentAlcohol, DrinkType drinkType){
        super(id,dateTime,amount,session,drinkType);
        this.percentAlcohol = percentAlcohol;
    }
}
