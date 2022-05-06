package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Post;
import Dao.PostDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.SQLException;
import java.sql.Timestamp;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    	try {
    		if (request.getParameter("written_text") == "") {
				request.setAttribute("error", "Post cannot be blank");
		    	request.getRequestDispatcher("auth.jsp").include(request, response);
    		}
        	Post post = new Post();
        	post.setProfileEmail(request.getParameter("profile_email"));
        	post.setWrittenText(request.getParameter("written_text"));
        	Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);
        	post.setCreatedDatetime(timestamp);

        	response.setContentType("text/html");
			postDao.post(post);
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
