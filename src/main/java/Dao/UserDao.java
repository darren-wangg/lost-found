package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Constant;
import Util.User;

public class UserDao {
	private static final String url = "jdbc:mysql://localhost:3306/lost_n_found";
    private static final String username_ = Constant.DBUserName;
    private static final String password_ = Constant.DBPassword;
    
    public static String getUsername(String email) throws ClassNotFoundException, SQLException{
    	String username = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String select = "SELECT * FROM user_profile WHERE email = ?";
			PreparedStatement preparedStatement = con.prepareStatement(select);	
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				username = resultSet.getString("username");
			}
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return username;
    }
	
	public int registerUser(User user) throws ClassNotFoundException, SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String insert = "INSERT INTO user_profile (email, username, password_) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			
			result = preparedStatement.executeUpdate();
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public boolean userExists(User user) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	// Check if email already exist in database
	    	String selectEmail = "SELECT * FROM user_profile WHERE email = ?";
			PreparedStatement preparedStatement1 = con.prepareStatement(selectEmail);		
			preparedStatement1.setString(1, user.getEmail());
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			if(resultSet1.next()){
				return true;
			}
			
			// Check if username already exist in database
			String selectUsername = "SELECT * FROM user_profile WHERE username = ?";
			PreparedStatement preparedStatement2 = con.prepareStatement(selectUsername);	
			preparedStatement2.setString(1, user.getUsername());
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			
			if(resultSet2.next()){
				return true;
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	// Returns 0 if success, 1 if user does not exist, 2 if password does not match
	public int login(User user) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String select = "SELECT * FROM user_profile WHERE username = ?";
			PreparedStatement preparedStatement = con.prepareStatement(select);	
			preparedStatement.setString(1, user.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				if(user.getPassword().equals(resultSet.getString("password_"))) {
					String email = resultSet.getString("email");
					user.setEmail(email);
					return 0;
				}
				else {
					return 2;
				}
			}
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return 1;
	}

//	public boolean googleLogin(User user) throws SQLException, ClassNotFoundException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//	    	Connection con = DriverManager.getConnection(url, username_, password_);
//	    	
//	    	String select = "SELECT * FROM user_profile WHERE email = ?";
//			PreparedStatement preparedStatement = con.prepareStatement(select);	
//			preparedStatement.setString(1, user.getEmail());
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			// if created account with password, google login fail
//			if(resultSet.next()){
//				if(resultSet.getString("password_") != null) {
//					return false;
//				}
//			}
//			else {
//				String insert = "INSERT INTO user_profile (email, name_) VALUES (?, ?);";
//				PreparedStatement preparedStatement2 = con.prepareStatement(insert);
//				preparedStatement2.setString(1, user.getEmail());
//				preparedStatement2.setString(2, user.getName());
//				
//				preparedStatement2.executeUpdate();
//			}
//		}
//		catch (Exception ex) {}
//		return true;
//    	
//	}
}
