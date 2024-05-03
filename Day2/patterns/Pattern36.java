package com.patterns;

//4 3 2 1 2 3 4 
//  3 2 1 2 3 
//    2 1 2 
//      1 
//    2 1 2 
//  3 2 1 2 3 
//4 3 2 1 2 3 4 

public class Pattern36 {
	public static void main(String[] args) {
		int n=7;
		int x=4;
		int space=0;
		int num=n;
		 for (int i = 1; i <= n; i++) {	 
	            for (int j = 1; j <= space; j++) {
	            	System.out.print("  ");
	            }
	            for (int j = 1; j <= num; j++) {
	            	 if (j <= num/2) {
	            		 
		                    System.out.print(x-- + " ");
		                    
		                } else {
		                	
		                    System.out.print(x++ + " ");
		                }
	            }
	            
	            System.out.println();
	            
	            if(i<=n/2) {
	            	space++;
	            	num = num-2;
	            	x=x-2;
	            }
	            else {
	            	space--;
	            	num = num+2;
	            	
	            }
	        
	        }
	}
}
