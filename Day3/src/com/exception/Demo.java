package com.exception;

public class Demo {
	public static void main(String[] args) {
		try {
			int a=2/0;
		}
		catch(Exception e) {
			e.printStackTrace();
					}
	}
}
