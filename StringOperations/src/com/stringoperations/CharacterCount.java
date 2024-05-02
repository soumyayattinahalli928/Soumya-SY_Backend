package com.stringoperations;

public class CharacterCount {
	public static void countEachCharacter(String str) {
		int count=0;
		for(int i=0; i<str.length();i++) {
			count++;
		}
		
		System.out.println("Number of character="+count);
	}
	
	public static void main(String[] args) {
		String str = "Soumya";
		countEachCharacter(str);
	}
}
