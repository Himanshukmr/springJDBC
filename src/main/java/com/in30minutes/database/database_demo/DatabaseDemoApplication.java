package com.in30minutes.database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in30minutes.database.database_demo.entity.Person;
import com.in30minutes.database.database_demo.jdbc.PersonJdbcDAO;



@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO personJdbcDAO ;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("All users --> {}",personJdbcDAO.findAll());
		
		logger.info("Person with id 1001 user --> {}",personJdbcDAO.findById(10001));
		
		logger.info("Person with name James user --> {}",personJdbcDAO.findByName("James"));
		
		logger.info("Delete Person with id 10003 user --> {}",personJdbcDAO.deleteById(10002,"James"));
		
		
		logger.info("Inserting Person  --> {} , No of updated row is->{}",
				personJdbcDAO.insertPerson(new Person(10004,"Hiamshu","Bihar",new Date())));
		
		logger.info("Updating Person,No of row updated is --> {}",personJdbcDAO.updatePerson(10004, "Himanshu"));
	
		logger.info("All users by using Custom RowMapper--> {}",personJdbcDAO.findAllPerson());
	
	}

}
