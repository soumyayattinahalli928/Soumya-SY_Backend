package com.linkedlist;


public class Employee implements Comparable<Employee> {
	String name;
	double salary;
	int deptno;
	String deptname;
	public Employee(String name, double salary, int deptno, String deptname) {
		super();
		this.name = name;
		this.salary = salary;
		this.deptno = deptno;
		this.deptname = deptname;
	}
	@Override
	public String toString()
	{
		return "Employee[name="+name+",salaray="+salary+",deptno="+deptno+",deptname="+deptname+"]";
	}
	@Override
	public int compareTo(Employee o)
	{
		return (int)(this.salary-o.salary);
	}
	

	
}

