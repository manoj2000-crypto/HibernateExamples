package OneToMay;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(name = "emp_name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "emp_email", length = 20, nullable = false, unique  = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emp")
	//@JoinTable(name = "newtable", joinColumns = @JoinColumn(name = "fk1"), inverseJoinColumns = @JoinColumn(name = "fk2"))
	private List<Address> addrses = new ArrayList<>(); 
	
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

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email 
				+ "]";
	}

	public List<Address> getAddrses() {
		return addrses;
	}

	public void setAddrses(List<Address> addrses) {
		this.addrses = addrses;
	}
	
	
	
}
