package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
		private static Connection con;
		
		public static void OpenConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/java","newuser","root123");
		}
		
		public static Connection getCon() {
			return con;
		}
		
		public static void CloseConnection() throws SQLException {
			if(con!=null) {
				con.close();
			}
		}
}
