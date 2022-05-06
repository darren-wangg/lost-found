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
import java.sql.SQLException;

/**
 * Servlet implementation class LoginDispatcher
 */
@WebServlet("/Login")
public class LoginDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private UserDao userDao = new UserDao();

    public LoginDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    	
    	try {
        	User user = new User();
        	user.setEmail(request.getParameter("username"));
        	user.setPassword(request.getParameter("password"));
        	
    		// Check if user already exists
    		response.setContentType("text/html");
			user = userDao.login(user);
			if(user.getEmail() == null || user.getEmail().contentEquals("")) {
				request.setAttribute("error", "User does not exist.");
		    	request.getRequestDispatcher("login.jsp").include(request, response);
			}
			else {
				// Create cookies
				String username = user.getUsername();
				Cookie c = new Cookie("username", username);
				Cookie c2 = new Cookie("email", request.getParameter("email"));
				c.setMaxAge(60*60);
				c2.setMaxAge(60*60);
				response.addCookie(c);
				response.addCookie(c2);
				
				response.sendRedirect("home.jsp");
			}
		} catch (Exception e) {		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
