package oneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "adharcard_details")
public class AdharCard {

	@Id
	private long adharId;
	private String dateOfBirth;

	public long getAdharId() {
		return adharId;
	}

	public void setAdharId(long adharId) {
		this.adharId = adharId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "aharId")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AdharCard [getAdharId()=" + getAdharId() + ", getDateOfBirth()=" + getDateOfBirth() + ", getPerson()="
				+ getPerson() + "]";
	}
	
}
