package com.stringoperations;

public class Palindrome {
	public static boolean isPalindrome(String str) {
	   	  String res="";
	   	  for(int i=str.length()-1; i>=0;i--) {
	   		  res = res+str.charAt(i);
	   	  }
	   	  if(str.equalsIgnoreCase(res)) {
	   		  return true;
	   	  }
	   	  else {
	   		  return false;
	   	  }
	}
	
	public static void main(String[] args) {
		
		String str = "malayalam";
		System.out.println(isPalindrome(str));
	}
}
