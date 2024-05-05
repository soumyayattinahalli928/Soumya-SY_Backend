package com.patterns;

//	   *
//	 * 	 *
//  *      *
// *        *
//  *      *
//    *   *
//      *

public class Pattern38 {
	
	public static void main(String args[])  
	{    
	int rows=4;   
 
		for(int i=1; i<=rows; i++)  
		{  
			for(int j=rows; j>i; j--)  
			{  
				//prints space        
				System.out.print(" ");  
			}  
			//prints symbol  
			System.out.print("*");  
			for(int j=1; j<(i-1)*2; j++)  
			{  
				//prints space      
				System.out.print(" ");  
			}  
			if(i==1)  
			{       
				System.out.println();  
			}  
			else  
			{           
				System.out.println("*");  
			}  
		}    
	 
		for(int i=rows-1; i>=1; i--)  
		{  
			for(int j=rows; j>i; j--)  
			{           
				System.out.print(" ");  
			}  
			
			System.out.print("*");  
			for(int j=1; j<(i-1)*2; j++)  
			{        
				System.out.print(" ");  
			}  
			if(i==1)  
			{          
				System.out.println();  
			}  
			else  
			{        
				System.out.println("*");  
			}  
		}  
	}  
}

