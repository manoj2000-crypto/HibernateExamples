package OneToMay;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{
		Session session = createConnection();
		saveEmployeeDetails(session, createEmployeeObjects());
	//	fetchEMployeeDetails(session, 1);
		fetchAddressDetails(session, 1);
	}

	private static void fetchAddressDetails(Session session, int i) {
		Address adrsObj = session.get(Address.class, 1);
		System.out.println(adrsObj);
		System.out.println(adrsObj.getEmp());

	}
	@SuppressWarnings("unused")
	private static void fetchEMployeeDetails(Session session, int primaryKey) {
		Employee empObj = session.get(Employee.class, 1);  //see addrs as well as emp, emp primary key is passed
		System.out.println(empObj);
		List<Address> adrsList = empObj.getAddrses();
		for(Address adrs : adrsList)
			System.out.println(adrs);

	}
	private static void saveEmployeeDetails(Session session, Employee catchEmpObj) {
		session.beginTransaction();
		//cascade type 
		session.persist(catchEmpObj);
		session.getTransaction().commit();

	}
	private static Employee createEmployeeObjects() {


		Employee empObj = new Employee();
		empObj.setEmail("hello@gmail.com");
		empObj.setName("hello");


		Address ofcAdrs = new Address();
		ofcAdrs.setCity("blre");
		ofcAdrs.setStreetname("jdfhdf");

		Address houseAdrs = new Address();
		houseAdrs.setCity("thane");
		houseAdrs.setStreetname("dkljfkf");

		Address hostelAdrs = new Address();
		hostelAdrs.setCity("blre");
		hostelAdrs.setStreetname("kdsfjkdfjdkf");

		empObj.getAddrses().add(ofcAdrs);
		empObj.getAddrses().add(houseAdrs);
		empObj.getAddrses().add(hostelAdrs);

		hostelAdrs.setEmp(empObj);
		houseAdrs.setEmp(empObj);
		ofcAdrs.setEmp(empObj);
		return empObj;
	}
	private static Session createConnection() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
		SessionFactory sessionFact =  config.buildSessionFactory();
		Session session =  sessionFact.openSession();
		return session;
	}
}

