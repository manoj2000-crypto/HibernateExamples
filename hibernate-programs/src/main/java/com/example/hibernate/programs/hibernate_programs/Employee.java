package com.example.hibernate.programs.hibernate_programs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//POJO CLASS
@Entity
public class Employee {
	
	@Id
	private int eId;
	private String eName;
	private double eSalary;
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double geteSalary() {
		return eSalary;
	}
	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}
	
}
