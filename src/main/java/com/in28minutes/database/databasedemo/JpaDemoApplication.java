package com.in28minutes.database.databasedemo;


import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User id 10001 -> {}", repository.findById(10001));
		logger.info("Inserting 10005 -> {}", repository.insert(new Person(10005,"Erick","Colombia",new Date())));
		logger.info("Update 10003 - {}", repository.update(new Person(10003,"Danna Valeria","Francia",new Date())));

		/*logger.info("All users -> {}", repository.findAll());
		logger.info("User id 10001 -> {}" , repository.findById(10001));
		logger.info("Name Camila -> {}", repository.findByName("Camila"));
		logger.info("Location Hyderab -> {}", repository.findByLocation("Hyderab"));
		logger.info("Deleting 10002 -> No of Rows Deleted - {}", repository.deleteById(10002));
	*/
	}

}
