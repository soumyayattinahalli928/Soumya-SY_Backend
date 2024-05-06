package com.interfaceexample;

public class TestImplements implements Showable{
	public void print(){
		System.out.println("Hello");
	}  
	public void show(){
		System.out.println("Welcome");
		
	} 
	
	public static void main(String args[]){  
		TestImplements obj = new TestImplements();  
		obj.print();  
		obj.show();  
	
	}  
	  
}
