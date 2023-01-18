package DBConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBUtil {
	public static Connection con;

	public static void OpenConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("-----Driver Loaded-------");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/java", "newuser", "root123");
		System.out.println("------Connected To MySQL-------");

	}

	public static Connection getCon() {
		return con;
	}

	public static void closeConnection() throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}
