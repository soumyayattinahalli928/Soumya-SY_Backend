package com.spring.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.spring.spring.constructor.Address;

public class Employee {
	
	private int empId;
	private String name;
	private List<String> phones;
	private Set<String> skills;
	private Map<String, String> nominees;
	
	public Employee(int empId, String name, List<String> phones, Set<String> skills, Map<String, String> nominees) {
		super();
		this.empId = empId;
		this.name = name;
		this.phones = phones;
		this.skills = skills;
		this.nominees = nominees;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public Map<String, String> getNominees() {
		return nominees;
	}

	public void setNominees(Map<String, String> nominees) {
		this.nominees = nominees;
	}
	
	
}
