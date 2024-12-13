package com.alurachallenge.literalura;

import com.alurachallenge.literalura.service.InteraccionConsola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private InteraccionConsola interaccionConsola;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		interaccionConsola.iniciar(); // Arranca el menú
	}
}
