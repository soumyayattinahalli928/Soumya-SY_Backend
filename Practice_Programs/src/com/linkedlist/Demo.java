package com.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo {
	public static void main(String args[]){  
		LinkedList<String> al=new LinkedList<String>();  
		al.add("Ravi");  
		al.add("true");  
		al.add("0");  
		al.add("true"); 
		
		Iterator<String> itr=al.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
		}  
}
