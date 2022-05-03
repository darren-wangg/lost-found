package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Constant;
import Util.Post;
import Util.User;

public class PostDao {
	private static final String url = "jdbc:mysql://localhost:3306/lost_n_found";
    private static final String username_ = Constant.DBUserName;
    private static final String password_ = Constant.DBPassword;
	
	public int post(Post post) throws ClassNotFoundException, SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
	    	
	    	String insert = "INSERT INTO user_post (id, profile_id, written_text, created_datetime) VALUES (?, ?, ?, ?);";
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1, post.getId());
			preparedStatement.setString(2, post.getProfileID());
			preparedStatement.setString(3, post.getWrittenText());
			preparedStatement.setString(4, post.getCreatedDatetime());
			
			result = preparedStatement.executeUpdate();
			
		}
		catch (Exception ex) {}
		return result;
	}
	
	/*
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
	}*/
}
