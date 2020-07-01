package com.challange.drinkcontrol.builders;

import com.challange.drinkcontrol.domain.BatchDrink;
import com.challange.drinkcontrol.domain.AlcoholicDrink;
import com.challange.drinkcontrol.domain.NonAlcoholicDrink;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BatchDrinkBuilder {

    private AlcoholicDrink alcoholicDrink;
    private NonAlcoholicDrink nonAlcoholicDrink;

    private BatchDrinkBuilder() {
    }

    public static BatchDrinkBuilder oneAlcoholicBatchDrink() {
        BatchDrinkBuilder builder = new BatchDrinkBuilder();
        builder.alcoholicDrink = new AlcoholicDrink();
        builder.alcoholicDrink.setId(10);
        builder.alcoholicDrink.setDateTime(LocalDateTime.now());
        builder.alcoholicDrink.setAmount(100);
        builder.alcoholicDrink.setResponsiblePerson("Someone alcoholic");
        builder.alcoholicDrink.setPercentAlcohol(35.5);
        return builder;
    }

    public static BatchDrinkBuilder oneNonAlcoholicBatchDrink() {
        BatchDrinkBuilder builder = new BatchDrinkBuilder();
        builder.nonAlcoholicDrink = new NonAlcoholicDrink();
        builder.nonAlcoholicDrink.setId(20);
        builder.nonAlcoholicDrink.setDateTime(LocalDateTime.now());
        builder.nonAlcoholicDrink.setAmount(200);
        builder.nonAlcoholicDrink.setResponsiblePerson("Someone non alcoholic");
        return builder;
    }

    public BatchDrink now() {
        return (BatchDrink) alcoholicDrink != null ? alcoholicDrink : nonAlcoholicDrink;
    }
}
