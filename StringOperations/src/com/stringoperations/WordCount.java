package com.stringoperations;

public class WordCount {
	public static int countWord(String str) {
		int count=0;
		String[] s1 = str.split(" ");
		for(int i=0;i<s1.length;i++) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str = "Hello World";
		System.out.println(str);
		System.out.println("Word count="+countWord(str));
	}
}
