package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Constant;
import Util.Like;

public class LikeDao {
	private static final String url = "jdbc:mysql://localhost:3306/lost_n_found";
	
	public int like(Like like) throws ClassNotFoundException, SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url, Constant.DBUserName, Constant.DBPassword);
	    	
	    	String insert = "INSERT INTO post_like (post_id, profile_email, created_time) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = con.prepareStatement(insert);
			preparedStatement.setString(1, like.getPostID());
			preparedStatement.setString(2, like.getProfileEmail());
			preparedStatement.setString(3, like.getCreatedTime());
			
			result = preparedStatement.executeUpdate();
			
		}
		catch (Exception ex) {}
		return result;
	}
}
