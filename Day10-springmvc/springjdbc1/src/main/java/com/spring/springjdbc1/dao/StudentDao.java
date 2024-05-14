package com.spring.springjdbc1.dao;

import com.spring.springjdbc1.entities.Student;

public interface StudentDao {

	public int insertStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudent(Student student);
}
