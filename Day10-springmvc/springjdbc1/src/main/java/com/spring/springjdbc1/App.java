package com.spring.springjdbc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.springjdbc1.JdbcConfig;
import com.spring.springjdbc1.dao.StudentDao;
import com.spring.springjdbc1.entities.Student;


public class App 
{
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao dao = context.getBean("studentDao", StudentDao.class);

		Student student = new Student();
//		student.setId(14);
//		student.setName("Ram");
//		student.setCity("Mysore");
//
//		int res = dao.insertStudent(student);
//		System.out.println(res);
		
		Student student2 = new Student();
		student2.setId(12);
		student2.setName("John");
		student2.setCity("Bangalore");
		
		dao.updateStudent(student2);
		System.out.println("updated");
		

		Student student1 = new Student();
		student1.setId(14);
		int res2 = dao.deleteStudent(student1);
		System.out.println(res2);

	}

}
