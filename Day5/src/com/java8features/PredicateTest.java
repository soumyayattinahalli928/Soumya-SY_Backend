package com.java8features;

import java.util.function.Predicate;

public class PredicateTest {
	 
	  static Boolean checkAge(int age){  
	        if(age>17)  
	            return true;  
	        else return false;  
	    }  
	    public static void main(String[] args){  
	         
	        Predicate<Integer> predicate =  PredicateTest::checkAge;  
	        
	        // Calling Predicate method  
	        boolean result = predicate.test(25);  
	        System.out.println(result);  
	    }  
}
