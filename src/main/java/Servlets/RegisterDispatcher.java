import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Constant;
import Util.User;
import Util.Helper;
import Dao.LikeDao;
import Dao.UserDao;

import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/Register") 

/**
 * Servlet implementation class RegisterDispatcher
 */
public class RegisterDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private UserDao userDao = new UserDao();

    public RegisterDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
		response.setContentType("text/html");
		String error = "";
		
		//creating error message formatting properly
		ArrayList<String> tempError = new ArrayList<>();
		tempError.add("<p>");

		String em = request.getParameter("register_email");
		String nm = request.getParameter("register_name");
		String un = request.getParameter("register_username");
		String pw = request.getParameter("register_password");
		String cp = request.getParameter("register_confirm_password");
		//if checkbox is null, then was not checked
		String tc = request.getParameter("register_terms_checkbox");
		
		if (em == null) em = "";
		if (nm == null) nm = "";
		if (un == null) un = "";
		if (pw == null) pw = "";
		if (cp == null) cp = "";
		
		//if passwords don't match
		if (!pw.equals(cp) && pw != "") {
			tempError.add("Passwords do not match");
			tempError.add(", "); 
		}
		//if password is empty
		else if (pw == "") {
			tempError.add("Password cannot be empty");
			tempError.add(", ");
		}
		//if name is invalid
		if (!Helper.validName(nm)) {
			tempError.add("Invalid Name");
			tempError.add(", ");
		}
		//if email is invalid
		if (!Helper.isValidEmail(em)) {
			tempError.add("Invalid Email");
			tempError.add(", ");
		}
		
		if (!Helper.usernameAlreadyRegistered(un, request, response)) {
			tempError.add("Username already registered");
			tempError.add(", ");
		}
		
		//if email is already registered
		else if (Helper.emailAlreadyRegistered(em, request, response)) {
			tempError.add("Email already registered, please use login");
			tempError.add(", ");
		}
		
		//if terms and conditions box was not checked
		if (tc == null) {
			tempError.add("Must check terms and conditions");
			tempError.add(", ");
		}
		
		//means an error was added with a comma after it,
		//so just remove the very last one for formatting
		if (tempError.contains(", ")) {
			tempError.remove(tempError.size() - 1);
			tempError.add("</p>");
			for (String er : tempError) {
				error += er;
			}
		}
		
		if (!error.equals("")) {
			request.setAttribute("error", error);
			request.getRequestDispatcher("auth.jsp").include(request, response);
		}

		//means successful user creation
		else {
			//add required user data into database
			String sql = "INSERT INTO user_profile(email, name_, username, password_) "
					+ "VALUES (\"" + em + "\", \"" + nm + "\", \"" + un + "\", \"" + pw + "\");";
			try (Connection conn = DriverManager.getConnection(Constant.DBLocation, Constant.DBUserName, Constant.DBPassword);
				      Statement st = conn.createStatement();) {
				st.executeUpdate(sql);
			} 
			catch (SQLException sqle) {
				System.out.println ("SQLException: " + sqle.getMessage());
			}
			
			//replacing possible space with +, so it is pass-able as a cookie
			StringBuffer temp = new StringBuffer();
			temp.append(nm);
			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == ' ') temp.replace(i, i + 1, "+");
			}
			nm = temp.toString();
			
			Cookie name = new Cookie("user_name", nm);
			response.addCookie(name);
			response.sendRedirect("index.jsp");
		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
