package dao;

import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method for user authentication(login)
public 	User authenticateUser(String email, String password) throws SQLException;
	
public String RegisterUser(String FirstName,String LastName,String email,String password,String dateofbirth) throws SQLException, Exception;
}
