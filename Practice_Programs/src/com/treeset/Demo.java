package com.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class Demo {
	public static void main(String args[]){  
		 
		TreeSet<String> set=new TreeSet<String>();  
		set.add("20");  
		set.add("Vijay");  
		set.add("true");  
		set.add("20");  
		  
		Iterator<String> itr=set.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		}  
}
