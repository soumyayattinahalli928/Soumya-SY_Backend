package com.spring.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/spring/collection/config.xml");
		
		Employee emp = (Employee) context.getBean("employee");
		
		System.out.println(emp.getEmpId());
		System.out.println(emp.getName());
		System.out.println(emp.getPhones());
		System.out.println(emp.getSkills());
		System.out.println(emp.getNominees());
	}
}
