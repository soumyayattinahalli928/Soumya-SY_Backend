package com.demo;

import java.util.Scanner;

public class Test {
	
	public static void arrayAscending(int arr[]) {
	
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int j=0;j<arr.length;j++) {
			System.out.println(arr[j]);
		}
	
		System.out.println("--------");	
		
	}	


	public static void arrayDescending(int arr[]) {
	
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int j=0;j<arr.length;j++) {
			System.out.println(arr[j]);
		}
	
			
		
	}	
	
	public static void main(String[] args) {
		System.out.println("Hello world");

		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of an array");
		int size = sc.nextInt();
		int[] numbers = new int[size];
		System.out.println("enter array elemets");
		for (int i = 0; i < size; i++) {
			numbers[i] = sc.nextInt();
		}
		
//
//		System.out.println("---------------");
//		int[] values = { 2, 6, 9, 3 };
//		for (int i = 0; i < values.length; i++) {
//			System.out.println(values[i]);
//		}
		
		arrayAscending(numbers);
		arrayDescending(numbers);
	}
}
