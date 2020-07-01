package com.challange.drinkcontrol.domain;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NonAlcoholicDrink extends BatchDrink {

    @Builder
    public NonAlcoholicDrink(Integer id, LocalDateTime dateTime,
                             Integer amount, Session session,
                             DrinkType drinkType) {
        super(id, dateTime, amount, session, drinkType);
    }
}
