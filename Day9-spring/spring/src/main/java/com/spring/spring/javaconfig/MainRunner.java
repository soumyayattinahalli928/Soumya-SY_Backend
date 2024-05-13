package com.spring.spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Student student1 = context.getBean("student", Student.class);
		
		System.out.println(student1);
		
		student1.study();
	}
}
