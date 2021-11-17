package servlets;

import java.io.IOException;

import blog.models.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PostsServices;

/**
 * Servlet implementation class Post
 */
@WebServlet("/post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostsServices postsServices = PostsServices.getInstance();
	private Article post; 
	
    /**
     * Default constructor. 
     */
    public PostServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		post = this.postsServices.getArticleByName(request.getParameter("title"));
		if (post == null ) {
			return; 
		}
		
		request.setAttribute("post", post);
		
		request.getRequestDispatcher("/WEB-INF/post.jsp")
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
