package manyToMany;

import java.util.ArrayList;
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
		//	fetchAddressDetails(session, 1);
	}

	private static void fetchAddressDetails(Session session, int i) {
		Address adrsObj = session.get(Address.class, 1);
		System.out.println(adrsObj);
		//System.out.println(adrsObj.getEmp());

	}
	@SuppressWarnings("unused")
	private static void fetchEMployeeDetails(Session session, int primaryKey) {
		Employee empObj = session.get(Employee.class, 1);  //see addrs as well as emp, emp primary key is passed
		System.out.println(empObj);
		List<Address> adrsList = empObj.getAddrses();
		for(Address adrs : adrsList)
			System.out.println(adrs);

	}
	private static void saveEmployeeDetails(Session session, List<Employee> empList) {
		for(Employee emp : empList) {
			session.beginTransaction();
			//cascade type 
			session.persist(emp);
			session.getTransaction().commit();
		}

	}
	private static List<Employee> createEmployeeObjects() {


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


		Employee empObj1 = new Employee();
		empObj1.setEmail("hello1@gmail.com");
		empObj1.setName("hello");


		Address ofcAdrs1 = new Address();
		ofcAdrs1.setCity("blre1");
		ofcAdrs1.setStreetname("jdfhdf");

		Address houseAdrs1 = new Address();
		houseAdrs1.setCity("thane1");
		houseAdrs1.setStreetname("dkljfkf");

		Address hostelAdrs1 = new Address();
		hostelAdrs1.setCity("blre1");
		hostelAdrs1.setStreetname("kdsfjkdfjdkf");

		empObj1.getAddrses().add(ofcAdrs1);
		empObj1.getAddrses().add(houseAdrs1);
		empObj1.getAddrses().add(hostelAdrs1);


		List<Employee> empList = new ArrayList<>();
		empList.add(empObj1);
		empList.add(empObj);
		return empList;
	}
	private static Session createConnection() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
		SessionFactory sessionFact =  config.buildSessionFactory();
		Session session =  sessionFact.openSession();
		return session;
	}
}

