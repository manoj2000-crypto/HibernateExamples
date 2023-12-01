package employeeProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApp {

	private static void saveEmployeeDetails(Session session, Employee catchEmpObj) {
		session.beginTransaction();
		//Integer insertedKey = (Integer) session.save(catchEmpObj);
	/*	session.save(catchEmpObj);  //saving emp
		session.save(catchEmpObj.getPermantAdrs()); //save adrs*/
		
		//cascade type 
		session.persist(catchEmpObj);
		session.getTransaction().commit();
		
	}
	private static Employee createEmployeeObjects() {
		
		//scanner class
    	Employee empObj = new Employee();
    	empObj.setName("Manoj");
    	empObj.setEmail("manojkale@mail.com");
    	
    	Address adrs = new Address();
    	adrs.setCity("Pune");
    	adrs.setStreetname("Old sangvi");
    	empObj.setPermantAdrs(adrs);  //employee + adrs details
    	
    	EducationalQualification educationQualification = new EducationalQualification();
    	educationQualification.setHigestDegree("BCA");
    	educationQualification.setFieldOfStudy("Computer Science");
    	educationQualification.setSchoolOrInstituteName("ZIBACAR, Pune");
    	educationQualification.setCompletionDate("18/04/2021");
    	empObj.setEducationalDetail(educationQualification); //employee + education
    	
    	return empObj;
	}
	private static Session createConnection() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).addAnnotatedClass(EducationalQualification.class);
		SessionFactory sessionFact =  config.buildSessionFactory();
		Session session = sessionFact.openSession();
		return session;
	}
	
	public static void main(String[] args) {
		
		Session session = createConnection();
    	Employee catchEmpObj = createEmployeeObjects();
    	saveEmployeeDetails(session, catchEmpObj);
		
	}

}
