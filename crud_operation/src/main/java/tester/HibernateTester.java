package tester;

import org.hibernate.SessionFactory;

import utils.HibernateUtils;


public class HibernateTester {

	public static void main(String[] args) {
		try (SessionFactory sf=HibernateUtils.getFactory()){
			System.out.println("Hibernate is up and running");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
