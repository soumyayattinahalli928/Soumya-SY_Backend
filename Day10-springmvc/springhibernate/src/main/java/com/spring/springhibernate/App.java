package com.spring.springhibernate;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.springhibernate.dao.StudentDao;
import com.spring.springhibernate.entities.Student;

public class App 
{
    public static void main( String[] args ){
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
    	
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	
    	Student student = new Student();
//    	student.setId(17);
//    	student.setName("Raju");
//    	student.setCity("Mysore");
    	
//    	studentDao.insert(student);
//    	System.out.println("data inserted");
    	
    	Student student1 = new Student();
    	student1.setId(15);
    	student1.setName("Ram");
    	student1.setCity("Bangalore");
    	
//    	studentDao.update(student1);
    	System.out.println("data updated");
    	
    	Student student3 = new Student();
    	student3.setId(13);
    	studentDao.delete(student3);
    	System.out.println("data deleted");
    	
    	List<Student> studentList = studentDao.getAllData(student);
    	Iterator<Student> i = studentList.iterator();
    	while(i.hasNext()) {
    		System.out.println(i.next());
    	}
	
    	
    }
}
