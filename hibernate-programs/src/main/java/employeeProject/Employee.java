package employeeProject;

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

	/* Here 4 types of primary key creation that are given below
	 * 1. AUTO
	 * 2. IDENTITY
	 * 3. SEQUENCE
	 * 4. TABLE
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//primary key generation by database --> 1 and increment by 1
	private Integer empId;
	
	@Column(name = "emp_name", length = 20, nullable = false)
	private String name;
	
	@Column(name = "emp_email", length = 20, nullable = false, unique  = true)
	private String email;
	
	//private EducationQual eduDetails (cascade = CascadeType.PERSIST)//if u save emp obj i ll auto save adrs obj

	@OneToOne(cascade = CascadeType.PERSIST)//if u save emp obj i ll auto save adrs obj
	@JoinColumn(name = "address_foreign_Key")
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

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "educationDetail_foreign_key")
	private EducationalQualification educationalDetail;
	
	public EducationalQualification getEducationalDetail() {
		return educationalDetail;
	}

	public void setEducationalDetail(EducationalQualification educationalDetail) {
		this.educationalDetail = educationalDetail;
	}	
}