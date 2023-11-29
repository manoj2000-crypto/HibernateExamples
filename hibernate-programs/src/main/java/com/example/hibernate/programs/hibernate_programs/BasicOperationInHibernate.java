package com.example.hibernate.programs.hibernate_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BasicOperationInHibernate {

	public static void main(String args[]) {
		Session session = createConnection();
		//savePerson(createPerson(),session); 
		//fetchPersonById(session);
		updatePersonById(session);
		//deltePerson(session);
	}

	@SuppressWarnings({ "unused", "deprecation" })
	private static void deltePerson(Session session) {
		Person personObj = session.get(Person.class, 100);
		if(personObj != null) {
			session.beginTransaction();

			session.delete(personObj);
			session.getTransaction().commit();
		}
		else System.out.println("record with the specified key is not present");
	}

	//@SuppressWarnings("deprecation")
	private static void updatePersonById(Session session) {
		Person personObj = session.get(Person.class, 999);
		if(personObj != null) {
			//in session if u do any changes it ll be visible in db even if u dont tell save or persist
			session.beginTransaction();
			personObj.setName("Divya");
			personObj.setLocation("Telangana");
			//session.saveOrUpdate(personObj);
			//session.save(personObj);
			session.getTransaction().commit();
			System.out.println(personObj);
		}
		else System.out.println("Record with the specified key is not present");
	}

	@SuppressWarnings("unused")
	private static void fetchPersonById(Session session) {
		Person personObj = session.get(Person.class, 999);
		if(personObj != null)
			System.out.println(personObj);
		else System.out.println("record with the specified key is not present");
	}

	@SuppressWarnings({ "unused", "deprecation" })
	private static void savePerson(Person personObj, Session session) {
		session.beginTransaction();
		int insertedKey = (int) session.save(personObj);
		System.out.println("one person object is inserted with key "+ insertedKey);
		session.getTransaction().commit();

	}

	@SuppressWarnings("unused")
	private static Person createPerson() {
		Person person = new Person();
		//read values 
		person.setLocation("Pune");
		person.setName("Manoj");
		person.setPersonId(999);
		return person;
	}

	private static Session createConnection() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Person.class);
		SessionFactory sessionFact =  config.buildSessionFactory();
		Session session = sessionFact.openSession();
		return session;
	}
}