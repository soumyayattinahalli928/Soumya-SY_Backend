package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Employee {
	int id;
	String name;
	double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		
		return this.id+" "+this.name+" "+this.salary;
	}
	
	@Override
	public int hashCode() {
	
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e = (Employee)obj;
		return this.hashCode()==e.hashCode() ;
	}
	
	
	public static void main(String[] args) {
		HashSet<Employee> hs = new HashSet<Employee>();
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter salary");
			double salary = sc.nextDouble();
			
			hs.add(new Employee(id, name, salary));
			
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
