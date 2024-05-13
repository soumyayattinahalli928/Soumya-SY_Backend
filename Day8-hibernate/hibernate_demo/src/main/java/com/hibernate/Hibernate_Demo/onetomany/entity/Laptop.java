package com.hibernate.Hibernate_Demo.onetomany.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int l_id;
	private String brand;
	private String serial_no;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Student1 student;
}
