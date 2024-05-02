package com.collection;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Employee() {
		super();
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		
		return "Employee ( Id = " + id + " Name = " + name + " Salary = " + salary + ")";
	}

//	@Override
//	public int compareTo(Employee o) {
//	
//		return this.id - o.id;
//	}
	
//	@Override
//	public int compareTo(Employee o) {
//	
//		return (int) (o.salary-this.salary);
//	}
	
	@Override
	public int compareTo(Employee o) {
	
		return this.name.compareTo(o.name);
	}
	
	

}
