package com.methods;

public class InstanceMethod {
	int s; 
	public int add(int a, int b)  
	{  
	s = a+b;    
	return s;  
	} 
	public static void main(String [] args)  
	{    
	InstanceMethod obj = new InstanceMethod();  
   
	System.out.println("The sum is: "+obj.add(10, 10));  
	}  
 	 
}
