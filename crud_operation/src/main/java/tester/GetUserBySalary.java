package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.UserDaoImpl;

public class GetUserBySalary {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
		UserDaoImpl userdao=new UserDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Salary : ");
		userdao.getUserBySalary(sc.nextDouble()).forEach(System.out::println);
		
		System.out.println("User Details Displayed Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
