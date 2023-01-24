package tester;

import java.time.LocalDate;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.Department;
import pojos.User;

public class GetUserByDateDept {

	public static void main(String[] args) {
		UserDaoImpl userdao=new UserDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Date And Department : ");
		User user=userdao.getUserBydDateDept(LocalDate.parse(sc.next()), Department.valueOf(sc.next().toUpperCase()));
		
		System.out.println(user);
	}

}
