package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import blog.models.Article;
import blog.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PostsServlet
 */
@WebServlet("/posts")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PostsServlet() {
        
    	List<User> users = new ArrayList<User>();
    	List<Article> articles = new ArrayList<Article>();
    	
    	for (int i = 1; i <= 5; i++) {
    		String role;
    		if (i % 2 == 0) role = "admin";
    		else role = "user";
    		users.add(new User("user" + i, i, "user" + i + "@email.com", role));
    	}
    	
    	for (User user : users) {
    		for (int i = 0; i < user.getNbrPost(); i++) {
    			articles.add(
    					new Article("title-" + user.getUsername(), 
    	    					"dzbh-"+ user.getUsername(), 
    	    					user)
    			);
    		}
    	}	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/posts.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
