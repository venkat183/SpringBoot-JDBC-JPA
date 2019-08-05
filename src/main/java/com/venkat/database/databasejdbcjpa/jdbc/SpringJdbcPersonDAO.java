package com.venkat.database.databasejdbcjpa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.venkat.database.databasejdbcjpa.entity.Person;

@Repository
public class SpringJdbcPersonDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("ID"));
			person.setName(rs.getString("NAME"));
			person.setLocation(rs.getString("Location"));
			person.setBirthDate(rs.getTimestamp("Birth_Date"));
			return person;
		}
		
		
	}

	public List<Person> getAll() {
		return jdbcTemplate.query("select * from PERSON", new PersonRowMapper());
	}

	public Person getById(int id) {
		return jdbcTemplate.queryForObject("select * from PERSON WHERE ID=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person getByName(String name) {
		return jdbcTemplate.queryForObject("select * from PERSON WHERE NAME=?", new Object[] { name },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("Delete from PERSON WHERE ID=?", new Object[] { id });
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("Insert into PERSON (ID,NAME,LOCATION,BIRTH_DATE) values(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()) });
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update(" Update PERSON SET Name = ?, Location =?, Birth_Date =? where Id=?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),
						person.getId() });
	}

}
