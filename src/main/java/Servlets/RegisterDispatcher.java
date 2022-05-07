package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.User;
import Dao.UserDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterDispatcher
 */
@WebServlet("/Register")
public class RegisterDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private UserDao userDao = new UserDao();

    /**
     * Default constructor.
     */
    public RegisterDispatcher() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email-register");
        String password = request.getParameter("password-register");
        String username = request.getParameter("username-register");
        User user = new User(email, username, password);
        
        // Check if user exists
        try {
        	response.setContentType("text/html");
			if(userDao.userExists(user)) {
				request.setAttribute("error", "User already exist.");
		    	request.getRequestDispatcher("register.jsp").include(request, response);
		    	return;
			}
			else {
				userDao.registerUser(user);
				
				// Create cookies
//				Cookie c = new Cookie("username", username);
//				Cookie c2 = new Cookie("email", email);
//				c.setMaxAge(60*60);
//				c2.setMaxAge(60*60);
//				response.addCookie(c);
//				response.addCookie(c2);
				
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
