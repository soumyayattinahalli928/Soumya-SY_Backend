package com.treemap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;




public class Employee   {
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

		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			//annonymous class
			
			Comparator<Integer> com = new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					
					return (o1).compareTo(o2);
				}
			};
			
			TreeMap<Integer, Employee> tm = new TreeMap<Integer, Employee>(com);
			
			while(true) {
		
				System.out.println("enter id");
				int id = sc.nextInt();
				System.out.println("enter name");
				String name = sc.next();
				System.out.println("enter designation");
				String designation = sc.next();
				System.out.println("enter department");
				String dept = sc.next();
				
				tm.put(id,new Employee(id, name, designation, dept));
				
				System.out.println("enter y to continue");
				char c = sc.next().charAt(0);
				
				if(c!='y') {
					break;
				}
			}
			//by default in asc order and its only for integer keys not for values. value sorting is not possible
			Set<Entry<Integer, Employee >> entryset = tm.entrySet();
			
			for(Entry<Integer, Employee > entry : entryset) {
				System.out.println(entry.getKey() + "=====>" + entry.getValue());
			}
			
			
		}
}
