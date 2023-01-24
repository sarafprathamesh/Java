package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import utils.HibernateUtils;
public class GetUserByDOB {

	public static void main(String[] args) {
		try(SessionFactory sf=HibernateUtils.getFactory()){
			UserDaoImpl userdao=new UserDaoImpl();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Date Of Birth : ");
			userdao.getUserByDOB(LocalDate.parse(sc.next())).forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
