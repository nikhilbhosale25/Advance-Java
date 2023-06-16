package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import pojos.User;

public class UserDaoImpl implements UserDao {
	// fields
	private Connection cn;
	private PreparedStatement pst1,pst2;

	public UserDaoImpl() throws SQLException {
		// open conn
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		//pre-parsed-Statement
		System.out.println("user dao created!");
		
		pst2 = cn.prepareStatement("insert into users value(default,?,?,?,?,?,?,?)");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// set IN params
		pst1.setString(1, email);		
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()) {
			if(rst.next())//=> success //Moves the cursor forward one row from its current position 
				/*
				 * int id, String firstName, String lastName, String email, String password, Date dob,
			boolean votingStatus, String role
				 */
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, 
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up!");
	}

	@Override
	public String RegisterUser(String FirstName, String LastName, String email, String password, String dateofbirth) throws Exception  
	{
		if(Period.between(LocalDate.parse(dateofbirth), LocalDate.now()).getYears()>21) 
		{
			Date d2=Date.valueOf(dateofbirth);
			//Date dob=Date.parse(dateofbirth);	
		
		
			pst2.setString(1,FirstName);
			pst2.setString(2,LastName);
			pst2.setString(3,email);
			pst2.setString(4,password);
			pst2.setDate(5, d2);
			pst2.setInt(6,0);
			pst2.setString(7,"voter");
			
			int a=pst2.executeUpdate();
			if(a==1)
			{
				return "Success";
			}
			else {
				System.out.println("failed ");
			}
		}
		return "Failed";
	}
	
	

}
