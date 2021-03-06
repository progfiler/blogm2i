package servlets;

import java.io.IOException;

import blog.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * 
 * @author antoinefissot
 *	Servlet de la page de login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Je crée un utilisateur en dur pour ma session 
		User userConnected = new User("Antoine", 3, "antoine@semifir.com", "user");
		
		// Je récupère ma session dans la request
		HttpSession session = request.getSession();
		// Je set mon utilisateur dans ma session
		session.setAttribute("USER", userConnected);
		
		// Je redirige mon utilisateur vers /blog/home 
		response.sendRedirect("/blog/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
