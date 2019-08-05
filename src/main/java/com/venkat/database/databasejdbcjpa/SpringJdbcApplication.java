package com.venkat.database.databasejdbcjpa;



import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.venkat.database.databasejdbcjpa.entity.Person;
import com.venkat.database.databasejdbcjpa.jdbc.SpringJdbcPersonDAO;;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SpringJdbcPersonDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*logger.info("All users -> {} ", spjDao.getAll());
		logger.info("Deleting the User ID:1003 -> {} ", spjDao.deleteById(1003));
		logger.info("Inserting the User ID:1004 -> {} ", spjDao.insertPerson(new Person(1004,"Hitler","Berlin",new Date())));
		logger.info("Updating the User ID:1002 -> {} ", spjDao.updatePerson(new Person(1002,"Mikee","Milwaukee",new Date())));*/
		
	}
}

