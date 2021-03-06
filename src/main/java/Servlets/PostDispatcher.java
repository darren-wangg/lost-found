package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Post;
import Util.User;
import Dao.PostDao;
import Dao.UserDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginDispatcher
 */
@WebServlet("/Post")
public class PostDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private PostDao postDao = new PostDao();

    public PostDispatcher() {
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
    		// Handled from frontend
//    		if (request.getParameter("written_text") == "") {
//				request.setAttribute("error", "Post cannot be blank");
//		    	request.getRequestDispatcher("createPost.jsp").include(request, response);
//    		}
        	Post post = new Post();
        	
        	// Get email
        	Cookie[] cookies = request.getCookies(); 
        	String email_ = "";
        	if(cookies != null) {
        		for (Cookie aCookie : cookies) {
        			if((aCookie.getName( )).equals("email")){
        				email_ = aCookie.getValue();
        			}
        		}
        	}
        	
        	// Throw error if user not logged in
        	if(email_.equals("")) {
        		request.setAttribute("error", "User is not logged in. Please login or create an account before posting.");
		    	request.getRequestDispatcher("createPost.jsp").include(request, response);
        	}
        	else {
        		// Set post variables
            	post.setProfileEmail(email_);
            	
            	// Set text
            	post.setWrittenText(request.getParameter("post-text"));
            	
            	// Set timestamp
            	Long datetime = System.currentTimeMillis();
                Timestamp timestamp = new Timestamp(datetime);
            	post.setCreatedDatetime(timestamp);

            	response.setContentType("text/html");
    			postDao.post(post);
    			
    			ArrayList<Post> posts = PostDao.getPosts();
    			request.setAttribute("posts", posts);
    			request.getRequestDispatcher("home.jsp").include(request, response);
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
        doGet(request, response);
    }
}

