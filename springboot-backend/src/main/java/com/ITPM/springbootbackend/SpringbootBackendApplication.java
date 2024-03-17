package com.ITPM.springbootbackend;

import com.ITPM.springbootbackend.model.Exams;
import com.ITPM.springbootbackend.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private ExamRepository examRepository;

	@Override
	public void run(String... args) throws Exception {
		Exams exams = new Exams();
		exams.setName("Kamal");
		exams.setProposal(10000L);
		exams.setProgress1(2000L);
		exams.setProgress2(4000L);
		examRepository.save(exams);

		Exams exams1 = new Exams();
		exams1.setName("Sunil");
		exams1.setProposal(11000L);
		exams1.setProgress1(2000L);
		exams1.setProgress2(4000L);
		examRepository.save(exams);

	}
}
