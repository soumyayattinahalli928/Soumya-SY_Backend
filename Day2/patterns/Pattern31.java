package com.patterns;



public class Pattern31 {
	public static void main(String[] args) {
		
			int n=5;
			char c='A';
			 for (int i = 1; i <= n; i++) {
		            for (int j = n; j >= 1; j--) {
		                if (j <= i) {
		                    System.out.print(c +" ");
		                    
		                } else {
		                    System.out.print("  ");
		                }
		                
		            }
		            for (int k = 2; k <= i; k++) {
		                System.out.print(c + " ");
		            }
		            System.out.println();
		            ++c;
		        }
		
		}
}
