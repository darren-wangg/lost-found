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
import java.io.Serial;
import java.sql.SQLException;

/**
 * Servlet implementation class GoogleDispatcher
 */
@WebServlet("/Google")
public class GoogleDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    
    UserDao userDao = new UserDao();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	try {
            //TODO 
            User user = new User();
        	user.setName(request.getParameter("name"));
        	user.setEmail(request.getParameter("email"));
    		
			if(userDao.googleLogin(user)) {
				// Create cookie
				String nameNoSpace = user.getName().replaceAll(" ", "_");
				Cookie c = new Cookie("name", nameNoSpace);
				c.setMaxAge(60*60);
				response.addCookie(c);

				
				response.setContentType("text/html");
				response.sendRedirect("index.jsp");
			}
			else {
				request.setAttribute("error", true);
		    	request.getRequestDispatcher("auth.jsp").include(request, response);
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
        doGet(request, response);
    }

}
