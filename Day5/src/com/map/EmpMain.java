package com.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

public class EmpMain{
	public static void main(String[] args) {
		HashMap<Integer, Employee> lm = new HashMap<>();
		Employee e1 = new Employee(12,"John","Admin", "System");
		Employee e2 = new Employee(10,"John","Admin", "System");
		Employee e3 = new Employee(14,"John","Admin", "System");
		
		lm.put(13, e1);
		lm.put(8, e2);
		lm.put(12, e3);
		
		Set<Entry<Integer, Employee >> entryset = lm.entrySet();
		for(Entry<Integer, Employee > entry : entryset) {
			System.out.println(entry.getKey() + "=====>" + entry.getValue());
		}
		
	}
}
