package com.linkedlist;



import java.util.Comparator;
import java.util.LinkedList;

public class Avg_Sal implements Comparable<Employee>{
	
	public static void main(String[] args) {
		LinkedList<Employee> l=new LinkedList();
		l.add(new Employee("Raju",18000,10,"manager"));
		l.add(new Employee("sita",17000,11,"Salesman"));
		l.add(new Employee("Ram",20000,17,"manager"));
		l.add(new Employee("arun",16000,12,"Admin"));
		l.add(new Employee("dinga",10000,15,"admin"));
		
		System.out.println(l);
		double sum=0;
		for(Employee e:l)
		{
			sum=sum+(e.salary);
		}
		//System.out.println("sum of salary="+sum);
		double avgsal=sum/l.size();
		System.out.println("Avg salary="+avgsal);
	}

	@Override
	public int compareTo(Employee o) {
		return 0;
	}
	

	

}

