package com.hibernate.Hibernate_Demo.onetoone.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MarksCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String grade;
	private int marks;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Student student;
}
