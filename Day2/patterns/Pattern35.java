package com.patterns;

//1 2 3 4 3 2 1 
//  1 2 3 2 1 
//    1 2 1 
//      1 
//    1 2 1 
//  1 2 3 2 1 
//1 2 3 4 3 2 1 

public class Pattern35 {
	public static void main(String[] args) {
		int n=7;
		
		int space=0;
		int num=n;
		 for (int i = 1; i <= n; i++) {
			 int x=1;
	            for (int j = 1; j <= space; j++) {
	            	
	            	System.out.print("  ");
	            }
	            for (int j = 1; j <= num; j++) {
	            	 if (j <= num/2) {
		                    System.out.print(x++ + " ");
		                    
		                } else {
		                    System.out.print(x-- + " ");
		                }
	            }
	            System.out.println();
	            if(i<=n/2) {
	            	space++;
	            	num = num-2;
	            	
	            }
	            else {
	            	space--;
	            	num = num+2;
	            }
	           
	        }
	}
}
