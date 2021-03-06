package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LikeDao;
import Util.Like;

import java.io.IOException;
import java.io.Serial;
import java.sql.Timestamp;

/**
 * Servlet implementation class LogoutDispatcher
 */
@WebServlet("/Like")
public class LikeDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private LikeDao likeDao = new LikeDao();

    public LikeDispatcher() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	try {
        	Like like = new Like();
        	String id = (String)request.getParameter("id");
        	like.setPostID(id);
        	
        	// Get email
        	Cookie[] cookies = request.getCookies(); 
        	String email_ = "";
        	if(cookies != null) {
        		for (Cookie aCookie : cookies) {
        			if((aCookie.getName()).equals("email")){
        				email_ = aCookie.getValue();
        			}
        		}
        	}
        	
        	// Throw error if user not logged in
//        	if(email_.equals("")) {
//        		request.setAttribute("error", "User is not logged in. Please login or create an account before liking.");
//		    	request.getRequestDispatcher("home.jsp").include(request, response);
//        	}
//        	else {
	        	like.setProfileEmail(email_);
	   	
	        	// Set timestamp
	        	Long datetime = System.currentTimeMillis();
	            Timestamp timestamp = new Timestamp(datetime);
	        	like.setCreatedTime(timestamp);
	
	        	response.setContentType("text/html");
				LikeDao.like(like);

				response.sendRedirect("home.jsp#Post" + id);
        	


			
		} catch (Exception e) {		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

}
