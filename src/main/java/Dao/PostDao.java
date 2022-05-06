package Dao;

import java.sql.*;
import java.util.ArrayList;

import Util.Constant;
import Util.Post;


public class PostDao {
	private static final String url = "jdbc:mysql://localhost:3306/lost_n_found";
    private static final String username_ = Constant.DBUserName;
    private static final String password_ = Constant.DBPassword;
	
	public int post(Post post) throws ClassNotFoundException, SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
	    	
	    	String insert = "INSERT INTO user_post (profile_email, written_text, created_datetime) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1, post.getProfileEmail());
			preparedStatement.setString(2, post.getWrittenText());
			preparedStatement.setTimestamp(3, post.getCreatedDatetime());
			
			result = preparedStatement.executeUpdate();
			
		}
		catch (Exception ex) {}
		return result;
	}
	
	public static ArrayList<Post> getPosts() throws ClassNotFoundException, SQLException {
		ArrayList<Post> posts = new ArrayList<Post>();
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	
	    	String select = "SELECT * FROM user_post ORDER BY created_datetime DESC";
			PreparedStatement preparedStatement = con.prepareStatement(select);	
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String profile_email = resultSet.getString("profile_email");
				String written_text = resultSet.getString("written_text");
				Timestamp created_datetime = resultSet.getTimestamp("created_datetime");
				Post post = new Post(id, profile_email, written_text, created_datetime);
				posts.add(post);
			}
		}
		catch (Exception ex) {}
		return posts;
	}
	
	public Integer getLikes(String post_id) throws ClassNotFoundException, SQLException {
		Integer likes = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, username_, password_);
	    	String sql = "{CALL GetGrade(?, ?)}";
	    	CallableStatement st = con.prepareCall(sql);
			st.setString(1, post_id);
			st.registerOutParameter(2, Types.INTEGER);
			st.executeUpdate();
			likes = st.getInt(3);
		}
		catch (Exception ex) {}
		return likes;
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
