package com.stringoperations;

public class IsAllVowelsPresent {
	public static boolean isAllVowelsPresent(String str) {
		String str1 = str.toLowerCase();
		if(str1.contains("a") && str1.contains("e") && str1.contains("i") && str1.contains("o") && str1.contains("u")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String str = "you are beautiful";
		System.out.println(str);
		System.out.println(isAllVowelsPresent(str));
	}
}
