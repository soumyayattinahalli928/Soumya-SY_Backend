package com.stringoperations;

public class VowelCount {
	public static void countVowel(String str) {
		int vowelCount=0;
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U') {
				vowelCount++;
			}
		}
		System.out.println("Vowel Count = "+vowelCount);
	}
	
	public static void main(String[] args) {
		String str = "hello world";
		System.out.println(str);
		countVowel(str);
	}
}
