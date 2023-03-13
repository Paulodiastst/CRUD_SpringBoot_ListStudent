package com.app.web;

import com.app.web.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner {

	public CrudSpringBootApplication(StudentRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

	private final StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Student student1 = new Student("Paulo", "Roberto", "paulo@gmail.com");
		repository.save(student1);

		Student student2 = new Student("Carlos", "Alberto", "carlos20@gmail.com");
		repository.save(student2);
		*/
	}
}
