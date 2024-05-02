package com.exception;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			
			int[] arr = new int[3];
			arr[7] = 23;
			int a=5/0;
			
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
			System.out.println("finally block");
		}
	}
}
