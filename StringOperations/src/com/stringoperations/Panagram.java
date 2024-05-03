package com.stringoperations;

public class Panagram {
	public static boolean isPanagram(String str) {
		str = str.toUpperCase();
		int[] freq = new int[26];
		for(int i=0;i<str.length();i++) {
			freq[str.charAt(i)-65]++;
		}
		for(int i=0;i<freq.length;i++) {
			if(freq[i]==0) {
				return false;
			}
		
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "abcdefghijklmnpoqrstuvwxyz";
		System.out.println(str);
		
		System.out.println(isPanagram(str));
	}
}
