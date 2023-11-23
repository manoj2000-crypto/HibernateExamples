package com.example.hibernate.programs.hibernate_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Employee emp = new Employee();
    	emp.seteId(11);
    	emp.seteName("Manoj");
    	emp.seteSalary(200.00);
    	
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	session.save(emp);
    	transaction.commit();
    	
        //System.out.println( "Hello World!" );
    }
}
