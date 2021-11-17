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
import services.PostsServices;


/**
 * Servlet implementation class PostsServlet
 */
@WebServlet("/posts")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Je crée une liste d'article  vide qui contiendra plus tard la liste de mes articles
	private List<Article> posts = new ArrayList<Article>();
	// Je crée une vraiable qui contiendra plus tard dans mon code un article
	private PostsServices postsServices = PostsServices.getInstance();
	
    /**
     * Default constructor. 
     */
    public PostsServlet() {
    	// Je récupère la liste de mes articles grâce au service postsServices et sa méthode getArticles()
    	this.posts = postsServices.getArticles();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Je passe les articles dans le JSP en lui set un attribut posts
		request.setAttribute("posts", posts);
		// Je renvoi le JSP posts
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
