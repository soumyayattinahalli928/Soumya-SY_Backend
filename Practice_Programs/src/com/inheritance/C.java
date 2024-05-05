package com.inheritance;

public class C extends B{
	public static void m3() {
		B.m2();
		System.out.println("Bye");
	}
	
	public static void main(String[] args) {
		m3();
	}
}
