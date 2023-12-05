package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(AdharCard.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Creating Person's object.
		Person person1 = new Person();
		person1.setPersonId(1);
		person1.setPersonName("Manoj");
		person1.setPhoneNumber(9876543456L);
		
		//creating AdharCard's object.
		AdharCard person1AdharCard = new AdharCard();
		person1AdharCard.setAdharId(89675860385867L);
		person1AdharCard.setDateOfBirth("19/19/1999");
		
		person1.setAharId(person1AdharCard); //internal connection between object
		
		person1AdharCard.setPerson(person1);
		
		session.beginTransaction();
		session.persist(person1); //saving the object
		session.getTransaction().commit();
		
		//To check the bi-directional way. we use get method : 
		AdharCard adhr = session.get(AdharCard.class, 1);
		//After using this line why it is getting "StackOverflowError".
		System.out.println(adhr);
		
		/* If we use Person object to store session.get -> it will give error,
		 * If we use child object then it will return "null".
		 * */
	}

}
