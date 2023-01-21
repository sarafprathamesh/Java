package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.DBManager;
import pojo.Credential;

public class CredDALImpl implements CredDAL {
	private Connection con;

	private PreparedStatement pstmt;

	public CredDALImpl() throws SQLException {
		con=DBManager.getCon();
		
		pstmt=con.prepareStatement("select * from users");
		
	}

	@Override
	public Credential ValidateUser(String username, String password) throws SQLException {
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		try(ResultSet rset=pstmt.executeQuery()){
			while(rset.next()) {
				Credential cred=new Credential(rset.getInt(1), username, password, rset.getString(4), rset.getString(5));
				return cred;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if(pstmt!=null) {
			pstmt.close();
		}
	}


}
