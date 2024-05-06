package com.treemap;

	import java.util.Comparator;
	import java.util.Iterator;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.TreeMap;
	import java.util.Map.Entry;


public class Employee2   {
			int id;
			String name;
			String designation;
			String dept;
			
			public Employee2(int id, String name, String designation, String dept) {
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
				
				//using annonymous class
				
				Comparator<String> com = new Comparator<String>() {
				

					@Override
					public int compare(String o1, String o2) {
						
						return o1.compareTo(o2);
					}
				};
				
				TreeMap<String, Employee2> tm = new TreeMap<String, Employee2>(com);
				//using lambda expression
//				TreeMap<String, Employee2> tm = new TreeMap<String, Employee2>((o1,o2) -> o1.compareTo(o2));
				
				//using references
				TreeMap<String, Employee2> tm1 = new TreeMap<>(com::compare);
				
				while(true) {
			
					System.out.println("enter id");
					int id = sc.nextInt();
					System.out.println("enter name");
					String name = sc.next();
					System.out.println("enter designation");
					String designation = sc.next();
					System.out.println("enter department");
					String dept = sc.next();
					
					tm.put(name,new Employee2(id, name, designation, dept));
					
					System.out.println("enter y to continue");
					char c = sc.next().charAt(0);
					
					if(c!='y') {
						break;
					}
				}
				//by default in asc order and its only for integer keys not for values. value sorting is not possible
				Set<Entry<String, Employee2 >> entryset = tm.entrySet();
				
				for(Entry<String, Employee2 > entry : entryset) {
					System.out.println(entry.getKey() + "=====>" + entry.getValue());
				}
				
				
			}
	

}
