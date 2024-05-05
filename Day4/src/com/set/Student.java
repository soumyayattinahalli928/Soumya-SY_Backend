package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Student {
	int id;
	String name;
	int age;
	float marks;
	
	public Student(int id, String name, int age, float marks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return this.id+" "+this.name+" "+this.age+" "+this.marks;
	}
	
	@Override
	public int hashCode() { 
		
		return this.age;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student s = (Student)obj;
		return this.hashCode()==s.hashCode() && this.marks==s.marks && this.name==s.name;
	}
	
	
	public static void main(String[] args) {
		HashSet<Student> hs = new HashSet<Student>();
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter age");
			int age = sc.nextInt();
			System.out.println("enter marks");
			float marks = sc.nextFloat();
			
			hs.add(new Student(id, name, age, marks));
			
			System.out.println("enter y to continue");
			char c = sc.next().charAt(0);
			
			if(c!='y') {
				break;
			}
		}
		Iterator i = hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
