package com.challange.drinkcontrol.builders;

import com.challange.drinkcontrol.domain.DrinkBatch;
import com.challange.drinkcontrol.domain.AlcoholicDrinkBatch;
import com.challange.drinkcontrol.domain.NonAlcoholicDrinkBatch;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BatchDrinkBuilder {

    private AlcoholicDrinkBatch alcoholicDrink;
    private NonAlcoholicDrinkBatch nonAlcoholicDrink;

    private BatchDrinkBuilder() {
    }

    public static BatchDrinkBuilder oneAlcoholicBatchDrink() {
        BatchDrinkBuilder builder = new BatchDrinkBuilder();
        builder.alcoholicDrink = new AlcoholicDrinkBatch();
        builder.alcoholicDrink.setId(10);
        builder.alcoholicDrink.setDateTime(LocalDateTime.now());
        builder.alcoholicDrink.setAmount(100);
        builder.alcoholicDrink.setResponsiblePerson("Someone alcoholic");
        builder.alcoholicDrink.setPercentAlcohol(35.5);
        return builder;
    }

    public static BatchDrinkBuilder oneNonAlcoholicBatchDrink() {
        BatchDrinkBuilder builder = new BatchDrinkBuilder();
        builder.nonAlcoholicDrink = new NonAlcoholicDrinkBatch();
        builder.nonAlcoholicDrink.setId(20);
        builder.nonAlcoholicDrink.setDateTime(LocalDateTime.now());
        builder.nonAlcoholicDrink.setAmount(200);
        builder.nonAlcoholicDrink.setResponsiblePerson("Someone non alcoholic");
        return builder;
    }

    public DrinkBatch now() {
        return (DrinkBatch) alcoholicDrink != null ? alcoholicDrink : nonAlcoholicDrink;
    }
}
