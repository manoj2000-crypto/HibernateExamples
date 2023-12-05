package oneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "person_with_adharcard")
public class Person {

	@Id
	private int personId;
	private String personName;
	private long phoneNumber;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToOne(cascade = CascadeType.PERSIST)
	private AdharCard aharId;

	public AdharCard getAharId() {
		return aharId;
	}

	public void setAharId(AdharCard aharId) {
		this.aharId = aharId;
	}

	@Override
	public String toString() {
		return "Person [getPersonId()=" + getPersonId() + ", getPersonName()=" + getPersonName() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getAharId()=" + getAharId() + "]";
	}

}
