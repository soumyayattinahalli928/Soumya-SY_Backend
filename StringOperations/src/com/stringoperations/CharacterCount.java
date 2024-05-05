package com.stringoperations;

public class CharacterCount {
	public static void countEachCharacter(String str) {
		
		int[] freq = new int[str.length()];
		char[] str1 = str.toCharArray();
		for(int i=0; i<str1.length;i++) {
			freq[i]=1;
			for(int j=i+1;j<str1.length;j++) {
				
				if(str1[i] == str1[j]) {
					str1[j]='@';
					freq[i]++;
				}
			}
			
		}
		
		for(int i=0;i<str1.length;i++) {
			if(str1[i]!='@')
			System.out.println(str1[i]+"----->"+freq[i]);
		}
	}
	
	public static void main(String[] args) {
		String str = "soumyasm";
		countEachCharacter(str);
	}
}
