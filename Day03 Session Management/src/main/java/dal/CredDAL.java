package dal;

import java.sql.SQLException;

import pojo.Credential;

public interface CredDAL {
	Credential ValidateUser(String username,String password)throws SQLException;
}
