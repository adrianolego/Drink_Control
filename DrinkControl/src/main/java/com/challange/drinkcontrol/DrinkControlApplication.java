package com.challange.drinkcontrol;

import com.challange.drinkcontrol.domain.Drink;
import com.challange.drinkcontrol.domain.DrinkAlcoholic;
import com.challange.drinkcontrol.domain.DrinkNonAlcoholic;
import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.repository.DrinkRepository;
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
    private DrinkRepository drinkRepository;

    public static void main(String[] args) {
        SpringApplication.run(DrinkControlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Session session1 = Session.builder().id(1).session("Session 1").build();
        Session session2 = Session.builder().id(2).session("Session 2").build();
        Session session3 = Session.builder().id(3).session("Session 3").build();
        Session session4 = Session.builder().id(4).session("Session 4").build();
        Session session5 = Session.builder().id(5).session("Session 5").build();

        sessionRepository.saveAll(Arrays.asList(session1, session2, session3, session4, session5));

        LocalDateTime localDateTime = LocalDateTime.now();
        Drink alcoholic1 =  DrinkAlcoholic.builder()
                .id(1)
                .dateTime(localDateTime)
                .amount(200)
                .session(session1)
                .percentAlcohol(25.0)
                .build();

        Drink nonAlcoholic1 = DrinkNonAlcoholic.builder()
                .id(1)
                .dateTime(localDateTime)
                .amount(100)
                .session(session2)
                .build();

        drinkRepository.save(alcoholic1);
        drinkRepository.save(nonAlcoholic1);

    }
}

