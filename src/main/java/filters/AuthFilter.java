package filters;

import java.io.IOException;
import java.net.http.HttpRequest;

import blog.models.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class AuthFilter
 * Permet de vérifier si l'utilisateur est admin ou non
 */
@WebFilter("/admin")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		// Je cast l'objet request en HttpServletRequest pour récupèrer la session et donc l'utilisateur connecté
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("USER");
	
		//  Je cast l'objet response en HttpServletResponse ce qui va me permettre de rediriger l'utilisateur s'il n'est pas admin
		HttpServletResponse res = (HttpServletResponse) response;
		
		// Je vérifie le rôle de l'utilisateur
		// Si != admin je redirige vers /blog/home
		if (!user.getRole().equals("admin")) {
			res.sendRedirect("/blog/home");
			return;
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
