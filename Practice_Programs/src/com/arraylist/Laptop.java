package com.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Laptop implements Comparable<Laptop> {
	String brand;
	double price;
	int ram;
	Laptop(String brand, double price, int ram)
	{
		this.brand=brand;
		this.price=price;
		this.ram=ram;
	}
	@Override
	public String toString()
	{
		return "Laptop[brand="+brand+",price="+price+",RAM="+ram+"]";
	}
	
	@Override
	public int compareTo(Laptop o) {
	
		return o.ram-this.ram;
	}
	
	public static void main(String[] args) {
		ArrayList<Laptop> a=new ArrayList();
		a.add(new Laptop("Dell",50000,128));
		a.add(new Laptop("hp",48000,120));
		a.add(new Laptop("Lenovo",55000,160));
		a.add(new Laptop("Think Pad",60000,180));
		System.out.println(a);
		Collections.sort(a);
		System.out.println("afetr sorting based on RAM");
		for(Laptop l:a)
		{
			System.out.println(l);
		}
	}
}

