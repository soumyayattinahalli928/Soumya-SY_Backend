package com.hashset;


import java.util.HashSet;
import java.util.Iterator;

public class HashSet_Methods {
	public static void main(String[] args) {
		HashSet s=new HashSet();
		
		//add
		s.add(20);
		s.add(19.4);
		s.add(true);
		s.add(null);
		s.add(20);
		s.add(null);
		System.out.println(s);
		HashSet s1=new HashSet(s);
		s1.add(20);
		s1.add(null);
		s1.add(false);
		s1.add("hii");
		System.out.println(s1);
		
		//search
		System.out.println(s1.contains(20));
		System.out.println(s.containsAll(s1));
		
		//traverse
		Iterator i=s.iterator(); 
		while(i.hasNext()) 
		{
			System.out.println(i.next());
		}
		
		for(Object o:s)
		{
			System.out.println(o);
		}
		
		//remove
		s1.retainAll(s);
		System.out.println(s1);
		s.remove(null);
		s1.removeAll(s1);
		System.out.println(s1);
		
		System.out.println(s1.isEmpty());
		System.out.println(s.size());
		
	}
}
