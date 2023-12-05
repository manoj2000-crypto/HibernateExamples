package manyToMany;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adrsId;
	private String streetname;
	private String city;
	
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
	
	
}
