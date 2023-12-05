package com.example.hibernate.programs.hibernate_programs;

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
		Scanner gettingInput = gettingInputFromUser();
		Employee catchEmpObj = createEmployeeObjects(gettingInput); //getting input from user.
		saveEmployeeDetails(session, catchEmpObj);
		//fetchEMployeeDetails(session, 1);
		fetchAddressDetails(session, 1);
	}
	private static Scanner gettingInputFromUser() {
		Scanner readInput = new Scanner(System.in);
		return readInput;
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
		System.out.println(empObj.getPermantAdrs());

	}
	private static void saveEmployeeDetails(Session session, Employee catchEmpObj) {
		session.beginTransaction();
		//Integer insertedKey = (Integer) session.save(catchEmpObj);
		/*	session.save(catchEmpObj);  //saving emp
		session.save(catchEmpObj.getPermantAdrs()); //save adrs*/

		//cascade type 
		session.persist(catchEmpObj);
		session.getTransaction().commit();

	}
	private static Employee createEmployeeObjects(Scanner scan) {

		//Creating Employee object.
		Employee empObj = new Employee();
		
		System.out.println("Enter email for employee : ");
		empObj.setEmail(scan.nextLine());
		System.out.println("Enter name for employee : ");
		empObj.setName(scan.nextLine());

		//Creating Address object.
		Address adrs = new Address();
		System.out.println("Enter city name : ");
		adrs.setCity(scan.nextLine());
		System.out.println("Enter Street Name : ");
		adrs.setStreetname(scan.nextLine());
		
		empObj.setPermantAdrs(adrs);  //employee + address details (uni-directinal)
		
		adrs.setEmp(empObj); //bi-directional
		
		return empObj;
	}
	private static Session createConnection() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
		SessionFactory sessionFact =  config.buildSessionFactory();
		Session session =  sessionFact.openSession();
		return session;
	}
}

