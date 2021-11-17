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
	// Je récupère l'instance de mon service PostsServices
	private PostsServices postsServices = PostsServices.getInstance();
	// Je crée une vraiable qui contiendra plus tard dans mon code un article 
	private Article post; 
	
    /**
     * Default constructor. 
     */
    public PostServlet() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Je récupère un article grâce au nom de l'article passé en paramètre de la requete (request.getParameter("title"))
		// Je le récupère grâce à la méthode getArticleByName de mon service postsServices
		// Je le stock dans la variable post
		post = this.postsServices.getArticleByName(
				request.getParameter("title")
		);
		// Si l'article n'existe pas je redirige vers le servlet de la liste des articles et je coupe le code (return)
		if (post == null ) {
			response.sendRedirect("/blog/posts");
			return; 
		}
		
		// Ici l'article existe 
		// Je l'envoi dans le JSP en le passant dans lrattribut POST 
		request.setAttribute("post", post);
		
		// Je renvoi vers le JSP de post
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
