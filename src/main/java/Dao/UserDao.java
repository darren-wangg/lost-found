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
	
	public int registerUser(User user) throws ClassNotFoundException, SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String insert = "INSERT INTO user_profile (email, name_, id, username, password_) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getId());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getPassword());
			
			result = preparedStatement.executeUpdate();
			
		}
		catch (Exception ex) {}
		return result;
	}
	
	public boolean userExists(User user) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String select = "SELECT * FROM user_profile WHERE email = ?";
			PreparedStatement preparedStatement = con.prepareStatement(select);	
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				return true;
			}
			
		}
		catch (Exception ex) {}
		return false;
	}
	
	public User login(User user) throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String select = "SELECT * FROM user_profile WHERE email = ?";
			PreparedStatement preparedStatement = con.prepareStatement(select);	
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				if(user.getPassword().equals(resultSet.getString("password_"))) {
					String name = resultSet.getString("name_");
					String id = resultSet.getString("id");
					String username = resultSet.getString("username");
					user.setName(name);
					user.setId(id);
					user.setUsername(username);
				}
			}
			
			
		}
		catch (Exception ex) {
			
		}
		return user;
	}

	public boolean googleLogin(User user) throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String select = "SELECT * FROM user_profile WHERE email = ?";
			PreparedStatement preparedStatement = con.prepareStatement(select);	
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// if created account with password, google login fail
			if(resultSet.next()){
				if(resultSet.getString("password_") != null) {
					return false;
				}
			}
			else {
				String insert = "INSERT INTO user_profile (email, name_) VALUES (?, ?);";
				PreparedStatement preparedStatement2 = con.prepareStatement(insert);
				preparedStatement2.setString(1, user.getEmail());
				preparedStatement2.setString(2, user.getName());
				
				preparedStatement2.executeUpdate();
			}
		}
		catch (Exception ex) {}
		return true;
    	
	}
}
