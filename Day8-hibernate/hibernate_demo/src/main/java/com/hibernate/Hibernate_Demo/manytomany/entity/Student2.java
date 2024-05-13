package com.hibernate.Hibernate_Demo.manytomany.entity;

import java.util.List;

import com.hibernate.Hibernate_Demo.onetomany.entity.Laptop;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "student_id")
	private int id;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "student_age")
	private int age;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Book> books;
}
