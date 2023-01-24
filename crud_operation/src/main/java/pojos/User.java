package pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="user",uniqueConstraints =@UniqueConstraint(columnNames = {"first_name","last_name"}))
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_name",length = 20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length=20)
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Department department;
	private LocalDate dob;
	private double salary;
	
	
	public User(String firstName, String lastName, String email, Department department, LocalDate dob, double salary) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.dob = dob;
		this.salary = salary;
	}


	public User() {
		
	}


	
	public User(Integer id, String firstName, String lastName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", department=" + department + ", dob=" + dob + ", salary=" + salary + "]";
	}
	
	
	
	
}
