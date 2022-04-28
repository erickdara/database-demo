package com.in28minutes.database.databasedemo;


import com.in28minutes.database.databasedemo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}" , dao.findById(10001));
		logger.info("Name Camila -> {}", dao.findByName("Camila"));
		logger.info("Location Hyderab -> {}", dao.findByLocation("Hyderab"));
		logger.info("Deleting 10002 -> No of Rows Deleted - {}", dao.deleteById(10002));
		logger.info("Inserting 10005 -> {}", dao.insert(new Person(10005,"Erick","Colombia",new Date())));
		logger.info("Update 10003 - {}", dao.update(new Person(10003,"Danna Valeria","Francia",new Date())));
	}

}
