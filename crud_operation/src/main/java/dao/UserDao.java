package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Department;
import pojos.User;

public interface UserDao {
	String addUser(User user);
	
	List<User> getUserBySalary(double salary);
	
	List<User> getUserByDOB(LocalDate dob);
	
	User tranferUser (String firstName, String lastName, String dname, double salary);
	
	User getUserById(Integer id);
	
	List<User> getAllUsers();
	
	String deleteUserBySalary(double salary);
	
	User getUserBydDateDept(LocalDate date,Department dept);
	
	List<User> getUsersByDept(Department dept);
	
//	List<User> get
}
