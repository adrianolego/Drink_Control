package com.challange.drinkcontrol;

import com.challange.drinkcontrol.domain.*;
import com.challange.drinkcontrol.domain.enuns.DrinkTypeEnum;
import com.challange.drinkcontrol.repository.BatchDrinkRepository;
import com.challange.drinkcontrol.repository.DrinkTypeRepository;
import com.challange.drinkcontrol.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class DrinkControlApplication implements CommandLineRunner {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BatchDrinkRepository drinkRepository;

    @Autowired
    private DrinkTypeRepository drinkTypeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DrinkControlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        DrinkType typeAlcoholic = DrinkType.builder()
                .id(DrinkTypeEnum.ALCOHOLIC.getCode())
                .description("Alcoholic")
                .capacity(500)
                .freeSpace(500)
                .totalStoreged(0)
                .build();

        DrinkType typeNonAlcoholic = DrinkType.builder()
                .id(DrinkTypeEnum.NON_ALCOHOLIC.getCode())
                .description("NonAlcoholic")
                .capacity(400)
                .freeSpace(400)
                .totalStoreged(0)
                .build();

        drinkTypeRepository.saveAll(Arrays.asList(typeAlcoholic, typeNonAlcoholic));
        drinkTypeRepository.saveAll(Arrays.asList(typeAlcoholic));

        Session session1 = Session.builder().id(1).sessionDescription("Session 1").build();
        Session session2 = Session.builder().id(2).sessionDescription("Session 2").build();
        Session session3 = Session.builder().id(3).sessionDescription("Session 3").build();
        Session session4 = Session.builder().id(4).sessionDescription("Session 4").build();
        Session session5 = Session.builder().id(5).sessionDescription("Session 5").build();

        sessionRepository.saveAll(Arrays.asList(session1, session2, session3, session4, session5));

        LocalDateTime localDateTime = LocalDateTime.now();
        DrinkBatch alcoholic1 = AlcoholicDrinkBatch.builder()
                .id(1)
                .dateTime(localDateTime)
                .amount(200)
                .session(session1)
                .percentAlcohol(25.0)
                .drinkType(typeAlcoholic)
                .build();

        DrinkBatch nonAlcoholic1 = NonAlcoholicDrinkBatch.builder()
                .id(2)
                .dateTime(localDateTime)
                .amount(100)
                .session(session2)
                .drinkType(typeNonAlcoholic)
                .build();

        drinkRepository.saveAll(Arrays.asList(alcoholic1, nonAlcoholic1));

    }
}

