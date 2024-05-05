package com.methods;

public class Student {
	private int roll;  
	private String name; 
	
	
	public Student(int roll, String name) {
		super();
		this.roll = roll;
		this.name = name;
	}
	
	public int getRoll()  
	{  
	return roll;  
	}  
	public void setRoll(int roll)  
	{  
	this.roll = roll;  
	}  
	public String getName()   
	{  
	return name;  
	}  
	public void setName(String name)   
	{  
	this.name = name;  
	}  
	public static void main(String[] args) {
	
		Student s = new Student(12,"ram");
		
		System.out.println("Roll no.: "+s.getRoll());  
		System.out.println("Student name: "+s.getName());  
		
	}  

}
