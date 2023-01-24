package tester;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class TransferUser {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			UserDaoImpl userdao=new UserDaoImpl();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter FirstName, LastName ,Department Name , Salary : ");
			User u=userdao.tranferUser(sc.next(),sc.next(), sc.next(),sc.nextDouble());
			System.out.println(u);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
