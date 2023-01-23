package tester;

import java.time.LocalDate;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.Department;
import pojos.User;

public class MainTester {

	public static void main(String[] args) {
		UserDaoImpl userDao=new UserDaoImpl();
		
		System.out.println("Enter user details : firstName, lastName, email, department, dob, salary");
		Scanner sc= new Scanner(System.in);
		User user=new User(sc.next(),sc.next(),sc.next(),Department.valueOf(sc.next().toUpperCase()),LocalDate.parse(sc.next()),sc.nextDouble());
		userDao.addUser(user);
		System.out.println("User Added to Database");
	}

}
