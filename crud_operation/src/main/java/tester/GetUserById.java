package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

public class GetUserById {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			UserDaoImpl userdao = new UserDaoImpl();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter User ID : ");
			User u=userdao.getUserById(sc.nextInt());
			System.out.println(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
