package com.polymorphisam;

public class Demo2 extends Demo {
	@Override
	public void m1() {
		System.out.println("m1 method of demo2 class");
	}
	
	public static void main(String[] args) {
		Demo2 d = new Demo2();
		d.m1();
		}
}
