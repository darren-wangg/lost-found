package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Constant;
import Util.Like;
import Util.Post;

public class LikeDao {
	private static final String url = "jdbc:mysql://localhost:3306/lost_n_found";
	
	public static int like(Like like) throws ClassNotFoundException, SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
	    	
	    	String insert = "INSERT INTO post_like (post_id, profile_email, created_time) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1, like.getPostID());
			preparedStatement.setString(2, like.getProfileEmail());
			preparedStatement.setTimestamp(3, like.getCreatedTime());
			
			result = preparedStatement.executeUpdate();
			
		}
		catch (Exception ex) {}
		return result;
	}
	
	public static int getLikes(Post p) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
	    	
	    	String count = "SELECT COUNT(*) AS likes FROM post_like pl INNER JOIN user_post up ON pl.post_id = up.id WHERE pl.post_id = " 
	    			+ p.getId() + ";";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(count);
			if(resultSet.next()){
			    result = resultSet.getInt("likes");
			}
			
		}
		catch (Exception ex) {}
		return result;
	}
}
