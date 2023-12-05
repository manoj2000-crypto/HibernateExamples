package com.example.hibernate.programs.hibernate_programs;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//primary key genr by db --> 1and inc by 1
	private Integer empId;
	
	@Column(name = "emp_name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "emp_email", length = 20, nullable = false, unique  = true)
	private String email;
	
	//private EducationQual eduDetails (cascade = CascadeType.PERSIST)//if u save emp obj i ll auto save adrs obj

	@OneToOne(cascade = CascadeType.PERSIST)//if u save emp obj i ll auto save adrs obj
	@JoinColumn(name = "foreignKey")
	private Address permantAdrs;  //permantAdrs_adrsId
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getPermantAdrs() {
		return permantAdrs;
	}

	public void setPermantAdrs(Address permantAdrs) {
		this.permantAdrs = permantAdrs;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", permantAdrs=" + permantAdrs
				+ "]";
	}
	
	
	
}
