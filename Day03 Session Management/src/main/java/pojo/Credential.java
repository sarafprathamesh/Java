package pojo;

public class Credential {
	private int id;
	private String username;
	private String password;
	private String email;
	private String city;

	public Credential(int id, String username, String password, String email, String city) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Credential [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", city=" + city + "]";
	}

}
