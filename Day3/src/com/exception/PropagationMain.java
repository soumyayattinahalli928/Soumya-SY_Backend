package com.exception;

public class PropagationMain  {
	public static void main(String[] args){
		try {
			Propagation.m1();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
