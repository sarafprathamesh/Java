package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import dao.UserDaoImpl;
import pojos.Department;

public class GetUsersByDepartment {

	public static void main(String[] args) {
		UserDaoImpl userdao=new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		try(SessionFactory sf=getFactory()){
			System.out.println("Enter Department : ");
			userdao.getUsersByDept(Department.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
