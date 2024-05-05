package com.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
	public static void main(String args[]){  
		ArrayList<String> list=new ArrayList<String>();  
		list.add("10"); 
		list.add("Vijay");  
		list.add("10");  
		list.add("null");  
		 
		Iterator itr=list.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		}  
}
