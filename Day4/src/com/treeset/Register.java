package com.treeset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.set.Student;

public class Register {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Comparator<Employee> com = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {		
				return ((Integer)o1.id).compareTo(o2.id);
			}
		};
		
		TreeSet<Employee> ts = new TreeSet<Employee>(com);
		
		while(true) {
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter salary");
			double salary = sc.nextDouble();
			
			ts.add(new Employee(id, name, salary));
			
			System.out.println("enter y to continue");
			char c = sc.next().charAt(0);
			
			if(c!='y') {
				break;
			}
		}
		Iterator i = ts.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
