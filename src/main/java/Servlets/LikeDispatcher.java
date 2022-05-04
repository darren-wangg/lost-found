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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
    	try {
        	Like like = new Like();
        	like.setPostID(request.getParameter("post_id"));
        	like.setProfileEmail(request.getParameter("profile_email"));
        	like.setCreatedTime(request.getParameter("created_time"));

        	response.setContentType("text/html");
			likeDao.like(like);
			
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