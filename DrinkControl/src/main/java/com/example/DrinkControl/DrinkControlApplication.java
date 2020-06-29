package com.example.DrinkControl;

import com.example.DrinkControl.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrinkControlApplication implements CommandLineRunner {

	@Autowired
	private SessionRepository sessionRepository;

	public static void main(String[] args) {
		SpringApplication.run(DrinkControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



	}
}

