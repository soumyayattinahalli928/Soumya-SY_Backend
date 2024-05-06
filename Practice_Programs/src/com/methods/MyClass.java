package com.methods;

public class MyClass extends Demo {
	    @Override
		void display()
		{  
		System.out.println("Abstract method?");  
		}  
		public static void main(String args[])  
		{  
		 
		Demo obj = new MyClass();   
		obj.display();  
		}  
	
}
