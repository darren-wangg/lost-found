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
        	user.setEmail(request.getParameter("email"));
        	user.setPassword(request.getParameter("password"));
        	
    		// Check if user already exists
    		response.setContentType("text/html");
			user = userDao.login(user);
			if(user.getName() == null || user.getName().contentEquals("")) {
				request.setAttribute("error", true);
		    	request.getRequestDispatcher("auth.jsp").include(request, response);
			}
			else {
				// Create cookie
				String nameNoSpace = user.getName().replaceAll(" ", "_");
				Cookie c = new Cookie("name", nameNoSpace);
				Cookie c2 = new Cookie("email", request.getParameter("email"));
				c.setMaxAge(60*60);
				c2.setMaxAge(60*60);
				response.addCookie(c);
				response.addCookie(c2);
				
				response.sendRedirect("index.jsp");
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
