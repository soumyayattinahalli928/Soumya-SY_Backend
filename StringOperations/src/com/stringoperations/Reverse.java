package com.stringoperations;

public class Reverse {
	public static void reverse(String str) {
		String rev = "";
		for(int i=str.length()-1;i>=0;i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println("reverse string = " +rev);
	}
	
	public static void main(String[] args) {
		String str = "rakesh";
		System.out.println(str);
		
		reverse(str);
	}
}
