package com.spring.spring.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	@Autowired
	@Qualifier("address1")
	private Address address;
	
//	public Employee(Address address) {
//		super();
//		this.address = address;
//	}
//
//	public Employee() {
//		super();
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
////	@Autowired
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	
}
