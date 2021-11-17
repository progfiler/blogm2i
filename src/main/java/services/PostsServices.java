package services;

import java.util.ArrayList;
import java.util.List;

import blog.models.Article;
import blog.models.User;

/**
 * 
 * @author antoinefissot
 * Création d'un service posts pour gérer les articles
 * Le service est un singleton 
 */
public class PostsServices {
	
	// Je crée une variable static qui contiendra l'instance de ma classe Posts Service 
	private static PostsServices instances = null;
	// Je crée une liste d'utilisateur vide
	private List<User> users = new ArrayList<User>();
	// Je crée une liste d'article vide
	private List<Article> posts = new ArrayList<Article>();
	
	// Je passe le contructeur en private 
	// Cela bloque la création d'instance de la classe en dehors de celle ci 
	// Ça permet de créer le singleton
	private PostsServices() {
		
		// Je crée une liste d'utilisateurs factice 
		// et je les injecte dans mon tableau d'utilisateurs
		for (int i = 1; i <= 10; i++) {
    		String role;
    		if (i % 2 == 0) role = "admin";
    		else role = "user";
    		users.add(new User("user" + i, i, "user" + i + "@email.com", role));
    	}
    	
		// Je crée une liste d'articles factice 
		// et je les injecte dans mon tableau d'articles
    	for (User user : users) {
    		for (int i = 0; i < user.getNbrPost(); i++) {
    			posts.add(
    					new Article("title"+i+"-" + user.getUsername(), 
    	    					"dzbh-"+ user.getUsername(), 
    	    					user)
    			);
    		}
    	}	
	}
	
	// Je crée un méthode static qui va me permettre de récupèrer l'instance de ma classe 
	public static PostsServices getInstance() {
		if (PostsServices.instances == null) {
			PostsServices.instances = new PostsServices();
		}
		return instances;
	}
	
	// Méthode qui renvoi le tableau des articles
	public List<Article> getArticles() {
		return this.posts; 
	}
	
	// Méthode qui permet de récupèrer un article selon son nom
	public Article getArticleByName(String title) {
		Article response = null;
		for (Article post : posts) {
			if (post.getTitle().equals(title)) {
				response = post;
				break;
			}
		}
		return response;
	}

}
