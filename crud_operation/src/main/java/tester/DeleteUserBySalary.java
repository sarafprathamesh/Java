package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
public class DeleteUserBySalary {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			UserDaoImpl userdao=new UserDaoImpl();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Salary : ");
			userdao.deleteUserBySalary(sc.nextDouble());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
