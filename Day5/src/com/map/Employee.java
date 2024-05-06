package com.map;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	int id;
	String name;
	String designation;
	String dept;
	
	public Employee(int id, String name, String designation, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + designation + " " + dept;
	}

	@Override
	public int compareTo(Employee o) {
		
		return this.id - o.id;
	}
	
}
