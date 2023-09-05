package com.mz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mz.app.model.Estudante;
import com.mz.app.repository.EstudanteRepository;

@SpringBootApplication
public class CrudSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootApplication.class, args);
	}
	
	@Autowired
	private EstudanteRepository estudanteRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Estudante e1 = new Estudante("Arsenio", "Langa", "arseniosergiolanga@gmail.com2222");
		estudanteRepository.save(e1);
		Estudante e2 = new Estudante("Arsenio", "Langa", "arseniosergiolanga@gmail.com433");
		estudanteRepository.save(e2);
		*/
		
	}

}
