package Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    /**
     * check if name is valid
     *
     * @param name the name user provides
     * @return valid or not valid
     */
    public static boolean validName(String name) {
        return Constant.namePattern.matcher(name).matches();
    }

    /**
     * check if email is valid
     *
     * @param email the email user provides
     * @return valid or not valid
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return Constant.emailPattern.matcher(email).matches();
    }

    /**
     * Get username with the email
     *
     * @param email
     * @return userName
     * @throws SQLException
     */
    public static String getName(String email) throws SQLException {
        //TODO
    	if (!isValidEmail(email)) {
    		return null;
    	}
    	
    	String name = "";
		String sql = "SELECT name_ FROM user_profile WHERE "
				+ "email = \"" + email + "\";";
		try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
			      Statement st = conn.createStatement();
				  ResultSet rs = st.executeQuery(sql);) {
			while (rs.next())
				name = rs.getString("name_");
		} 
		catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
		}
    	return name;
    }

    public static String getUsername(String email) throws SQLException {
    	if (!isValidEmail(email)) {
    		return null;
    	}
    	
    	String uname = "";
		String sql = "SELECT username FROM user_profile WHERE "
				+ "email = \"" + email + "\";";
		try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
			      Statement st = conn.createStatement();
				  ResultSet rs = st.executeQuery(sql);) {
			while (rs.next())
				uname = rs.getString("username");
		} 
		catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
		}
    	return uname;
    }
    
    public static int getUserID(String email) throws SQLException {
    	int id = -1;
		String sql = "SELECT username FROM user_profile WHERE "
				+ "email = \"" + email + "\";";
		try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
			      Statement st = conn.createStatement();
				  ResultSet rs = st.executeQuery(sql);) {
			while (rs.next())
				id = rs.getInt("id");
		} 
		catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
		}
    	return id;
    }

    /**
     * check if the email and password matches
     *
     * @param email
     * @param password
     */
    public static boolean checkPassword(String email, String password) throws SQLException {
    	if (!isValidEmail(email)) {
    		return false;
    	}
    	
    	String pw = "";
		String sql = "SELECT password_ FROM user_profile WHERE "
				+ "email = \"" + email + "\";";
		try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
			      Statement st = conn.createStatement();
				  ResultSet rs = st.executeQuery(sql);) {
			while (rs.next())
				pw = rs.getString("password_");
		} 
		catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
		}
		
        return pw.equals(password);
    }

    /**
     * Check if email is already registered
     *
     * @param email
     * @param request
     * @param response
     * @return email registered or not
     * @throws ServletException
     * @throws IOException
     */
    public static boolean emailAlreadyRegistered(String email, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	if (!isValidEmail(email)) {
    		return false;
    	}
    	
    	//counts how many users with this email exists (will be at most 1)
    	int count = 0;
		String sql = "SELECT COUNT(email) AS counter FROM user_profile WHERE "
				+ "email = \"" + email + "\";";
		try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
			      Statement st = conn.createStatement();
				  ResultSet rs = st.executeQuery(sql);) {
			while (rs.next())
				count = rs.getInt("counter");
		} 
		catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
		}
        return count > 0;
    }
    
    /**
     * Check if email is already registered
     *
     * @param email
     * @param request
     * @param response
     * @return email registered or not
     * @throws ServletException
     * @throws IOException
     */
    public static boolean usernameAlreadyRegistered(String uname, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//counts how many users with this username exists (will be at most 1)
    	int count = 0;
		String sql = "SELECT COUNT(username) AS counter FROM user_profile WHERE "
				+ "username = \"" + uname + "\";";
		try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
			      Statement st = conn.createStatement();
				  ResultSet rs = st.executeQuery(sql);) {
			while (rs.next())
				count = rs.getInt("counter");
		} 
		catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
		}
        return count > 0;
    }
}
