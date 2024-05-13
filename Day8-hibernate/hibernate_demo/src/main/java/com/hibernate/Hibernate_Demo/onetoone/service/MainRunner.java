package com.hibernate.Hibernate_Demo.onetoone.service;

import com.hibernate.Hibernate_Demo.onetoone.entity.MarksCard;
import com.hibernate.Hibernate_Demo.onetoone.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainRunner {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		MarksCard mc = new MarksCard();
		Student s = new Student();
		
		s.setName("John");
		s.setAge(23);
		s.setMarksCard(mc);
		
		mc.setGrade("A");
		mc.setMarks(90);
		
		transaction.begin();
		manager.persist(s);
		transaction.commit();
		
		manager.close();
		
	}

}
