package com.hibernate.Hibernate_Demo.onetomany.service;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.Hibernate_Demo.onetomany.entity.Laptop;
import com.hibernate.Hibernate_Demo.onetomany.entity.Student1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainRunner {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		List<Laptop> laptop = new ArrayList<>();
		Laptop laptop1 = new Laptop();
		Laptop laptop2 = new Laptop();
		Laptop laptop3 = new Laptop();
		
		Student1 s = new Student1();
		
		laptop1.setBrand("Dell");
		laptop1.setSerial_no("jwhuwjhdoq12");
		laptop1.setStudent(s);
		
		laptop2.setBrand("hp");
		laptop2.setSerial_no("ksnjsjis23");
		laptop2.setStudent(s);
		
		laptop3.setBrand("lenovo");
		laptop3.setSerial_no("kaksaaa45");
		laptop3.setStudent(s);
		
		laptop.add(laptop1);
		laptop.add(laptop2);
		laptop.add(laptop3);
		
		s.setAge(21);
		s.setName("John");
		s.setLaptops(laptop);
		
		transaction.begin();
		manager.persist(s);
		transaction.commit();
		
		manager.close();
	}
}
