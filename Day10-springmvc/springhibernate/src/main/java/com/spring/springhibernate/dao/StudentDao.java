package com.spring.springhibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.springhibernate.entities.Student;

@Component
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//insert
	@Transactional
	public int insert(Student student) {
		
		Integer i = (Integer) hibernateTemplate.save(student);
		return i;
	}
	
	//get all data
	@Transactional
	public List<Student> getAllData(Student student) {
		
		List<Student> studentDetails = hibernateTemplate.loadAll(Student.class);
		return studentDetails;
	}
	
	//delete
	@Transactional
	public void delete(Student student) {
//		Student studentId = hibernateTemplate.get(Student.class, student.getId());
//		System.err.println(studentId);
		hibernateTemplate.delete(student);
		
	}
	
	//update
	@Transactional
	public void update(Student student) {
		
		hibernateTemplate.update(student);
	}
	

}
