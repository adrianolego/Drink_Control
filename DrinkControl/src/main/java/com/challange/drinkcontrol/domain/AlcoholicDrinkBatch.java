package com.challange.drinkcontrol.domain;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AlcoholicDrinkBatch extends DrinkBatch {

    private Double percentAlcohol;

    @Builder
    public AlcoholicDrinkBatch(Integer id, LocalDateTime dateTime,
                               Integer amount, Session session,
                               DrinkType drinkType, Double percentAlcohol) {
        super(id, dateTime, amount, session, drinkType);
        this.percentAlcohol = percentAlcohol;
    }
}
