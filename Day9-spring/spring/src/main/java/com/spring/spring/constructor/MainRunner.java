package com.spring.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRunner {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/spring/constructor/config.xml");
	
		Employee emp = (Employee) context.getBean("employee");
		
		System.out.println(emp);
	}
	
}
