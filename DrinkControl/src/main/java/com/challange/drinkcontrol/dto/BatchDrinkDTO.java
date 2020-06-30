package com.challange.drinkcontrol.dto;

import com.challange.drinkcontrol.domain.BatchDrink;
import com.challange.drinkcontrol.domain.DrinkAlcoholic;
import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.domain.enuns.DrinkTypeEnum;
import com.challange.drinkcontrol.service.validation.BatchDrinkUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@BatchDrinkUpdate
public class BatchDrinkDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "Required field")
    private Integer amount;
    private LocalDateTime dateTime;
    @NotEmpty(message = "Required field")
    private Integer idSession;
    @NotEmpty(message = "Required field")
    private Integer idDrinkType;
    @NotEmpty(message = "Required field")
    private String responsiblePerson;

    public BatchDrinkDTO(Integer id, LocalDateTime dateTime, Integer amount, Integer idSession, Integer idDrinkType) {
        this.id = id;
        this.dateTime = dateTime;
        this.amount = amount;
        this.idSession = idSession;
        this.idDrinkType = idDrinkType;
    }
}
