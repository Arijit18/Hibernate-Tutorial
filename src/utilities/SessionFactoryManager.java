package utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryManager {

	public static SessionFactory sessionFactory;
	
	public static void buildSessionFactory(){
		
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.err.println("Session factory successfully created.");
		}catch(Throwable ex){
			System.err.println("Unable to build session factory.");
		}
	}
}
