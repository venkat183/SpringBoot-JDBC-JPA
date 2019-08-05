package com.venkat.database.databasejdbcjpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.venkat.database.databasejdbcjpa.entity.Person;


@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	com.venkat.database.databasejdbcjpa.jpa.PersonJpaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User 1001 -> {} ", repo.getById(1001));
		logger.info("Inserting the User ID:1004 -> {} ", repo.insertPerson(new Person("Hitler","Berlin",new Date())));
		logger.info("Updating the User ID:1002 -> {} ", repo.updatePerson(new Person(1002,"Mikee","Milwaukee",new Date())));
		repo.deleteById(1003);
		logger.info("All users -> {} ", repo.findAll());
		/*logger.info("Deleting the User ID:1003 -> {} ", spjDao.deleteById(1003));
		logger.info("Inserting the User ID:1004 -> {} ", spjDao.insertPerson(new Person(1004,"Hitler","Berlin",new Date())));
		logger.info("Updating the User ID:1002 -> {} ", spjDao.updatePerson(new Person(1002,"Mikee","Milwaukee",new Date())));*/
	}

}
