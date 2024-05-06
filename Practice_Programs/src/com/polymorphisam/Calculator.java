package com.polymorphisam;

public class Calculator {
	public static void add(int a, int b) {
		System.out.println(a+b);
	}
	public static void add(int a, float b) {
		System.out.println(a+b);
	}
	public static void add(float b, int a) {
		System.out.println(a+b);
	}
	public static void add(float b, int a, float c) {
		System.out.println(a+b+c);
	}
	
	public static void main(String[] args) {
		add(10,20);
		add(20,12.9f);
		add(19.8f, 20);
		add(1.23f, 30, 23.9f);
		
	}
}
