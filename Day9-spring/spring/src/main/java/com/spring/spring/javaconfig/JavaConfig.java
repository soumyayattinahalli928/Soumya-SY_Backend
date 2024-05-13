package com.spring.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.spring.javaconfig")
public class JavaConfig {
//
//	@Bean
//	public Student getStudent() {
//		return new Student(getSamosa());
//	}
//	
//	@Bean
//	public Samosa getSamosa() {
//		return new Samosa();
//	}
}
