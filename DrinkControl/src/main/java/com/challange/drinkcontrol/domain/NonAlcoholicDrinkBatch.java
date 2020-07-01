package com.challange.drinkcontrol.domain;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NonAlcoholicDrinkBatch extends DrinkBatch {

    @Builder
    public NonAlcoholicDrinkBatch(Integer id, LocalDateTime dateTime,
                                  Integer amount, Session session,
                                  DrinkType drinkType) {
        super(id, dateTime, amount, session, drinkType);
    }
}
