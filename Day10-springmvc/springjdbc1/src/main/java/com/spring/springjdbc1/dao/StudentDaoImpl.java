package com.spring.springjdbc1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.springjdbc1.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertStudent(Student student) {

		String query = "insert into student1 (id,name,city) values(?,?,?)";
		return jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
	}

	@Override
	public int updateStudent(Student student) {
		
		String query = "update student1 set name=?, city=?  where id=?";
		return jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
	}


	@Override
	public int deleteStudent(Student student) {
		
		String query = "delete from student1 where id = ? ";
		return jdbcTemplate.update(query,student.getId());
	}


		
		
	
}
