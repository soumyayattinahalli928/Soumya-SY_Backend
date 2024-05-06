package com.inheritance;

public class B extends A{
	public static void m2() {
		A.m1();
		System.out.println("hello");
	}
}
