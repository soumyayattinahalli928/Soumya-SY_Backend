package com.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Demo {
	public static void main(String args[]){  
		LinkedHashSet<String> set=new LinkedHashSet<String>();  
		set.add("true");  
		set.add("20");  
		set.add("true");  
		set.add("null"); 
		
		Iterator<String> itr=set.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		}  
}
