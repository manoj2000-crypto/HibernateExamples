package com.example.hibernate.programs.hibernate_programs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adrsId;
	private String streetname;
	private String city;

	@OneToOne(mappedBy = "permantAdrs")
	private Employee emp;

	public Integer getAdrsId() {
		return adrsId;
	}

	public void setAdrsId(Integer adrsId) {
		this.adrsId = adrsId;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [adrsId=" + adrsId + ", streetname=" + streetname + ", city=" + city + "]";
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
}
