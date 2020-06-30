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
@JsonTypeName("nonAlcoholic")
public class DrinkNonAlcoholic extends BatchDrink {

    @Builder
    public DrinkNonAlcoholic(Integer id, LocalDateTime dateTime,
                             Integer amount, Session session, DrinkType drinkType) {
        super(id, dateTime, amount, session, drinkType);
    }
}
