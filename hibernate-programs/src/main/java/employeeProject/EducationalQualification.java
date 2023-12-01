package employeeProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EducationalQualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationDetailId;
	
	@Column(name = "emp_degree", length = 40, nullable = false)
	private String higestDegree;
	
	@Column(name = "emp_major", length = 40, nullable = false)
	private String fieldOfStudy;
	
	@Column(name = "emp_institute", length = 40, nullable = false)
	private String SchoolOrInstituteName;
	
	private String completionDate;

	public int getEducationDetailId() {
		return educationDetailId;
	}

	public void setEducationDetailId(int educationDetailId) {
		this.educationDetailId = educationDetailId;
	}

	public String getHigestDegree() {
		return higestDegree;
	}

	public void setHigestDegree(String higestDegree) {
		this.higestDegree = higestDegree;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getSchoolOrInstituteName() {
		return SchoolOrInstituteName;
	}

	public void setSchoolOrInstituteName(String schoolOrInstituteName) {
		SchoolOrInstituteName = schoolOrInstituteName;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	
	
}
