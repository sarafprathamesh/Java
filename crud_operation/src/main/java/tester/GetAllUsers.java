package tester;

import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.UserDaoImpl;

public class GetAllUsers {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			UserDaoImpl userdao=new UserDaoImpl();
			
			userdao.getAllUsers().forEach(System.out::println);
		}

	}

}
