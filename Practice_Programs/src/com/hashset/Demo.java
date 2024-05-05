package com.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class Demo {
	public static void main(String args[]){  
		 
		HashSet<String> set=new HashSet<String>();  
		set.add("hii");  
		set.add("10");  
		set.add("hii");  
		set.add("null");  
		 
		Iterator<String> itr=set.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		}  
}
