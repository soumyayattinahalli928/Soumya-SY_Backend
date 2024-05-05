package com.casting;

public class Driver {
	public static void main(String[] args) {
		
		Sample s=new Sample();
		System.out.println(s.a);
		System.out.println(s.b);
		s.check();
		s.test();
		
		System.out.println("-----up casting-----");
		Demo d=s;  //up casting
		System.out.println(d.a);
		//System.out.println(d.b); CTE-sub class properties
		d.check();
		//d.test(); -CTE
		
		System.out.println("-----down casting-----");
		Sample s1=(Sample)d;  //down casting
		System.out.println(s1.a);
		System.out.println(s1.b);
		s1.check();
		s1.test();
	}

}

