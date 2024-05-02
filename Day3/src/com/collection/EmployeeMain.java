package com.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		List<Employee> list = new LinkedList<>();
		
		while(true) {
			Scanner sc =new Scanner(System.in);
			System.out.println("enter emp id");
			int id = sc.nextInt();
			System.out.println("enter emp name");
			String name = sc.next();
			System.out.println("enter emp salary");
			double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
			
			System.out.println("if you want to add few more data press y else n");
			char c = sc.next().charAt(0);
			
			if(c!='y')
				break;
		}
		
		Collections.sort(list);
		
		list.forEach(System.out::println);
		
	
	}
}
