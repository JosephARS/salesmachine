package com.globant.retojava.hr;

import com.globant.retojava.hr.entity.Employee;
import com.globant.retojava.hr.repository.EmployeeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			repository.save(new Employee(0, "AA", false));
			repository.save(new Employee(0, "BB", false));
			repository.save(new Employee(0, "CC", false));
		};
	}
}
