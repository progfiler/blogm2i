package services;

import java.util.ArrayList;
import java.util.List;

import blog.models.Article;
import blog.models.User;

public class PostsServices {
	
	private static PostsServices instances = null;
	private List<User> users = new ArrayList<User>();
	private List<Article> posts = new ArrayList<Article>();
	
	private PostsServices() {
		for (int i = 1; i <= 10; i++) {
    		String role;
    		if (i % 2 == 0) role = "admin";
    		else role = "user";
    		users.add(new User("user" + i, i, "user" + i + "@email.com", role));
    	}
    	
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
	
	public static PostsServices getInstance() {
		if (PostsServices.instances == null) {
			PostsServices.instances = new PostsServices();
		}
		return instances;
	}
	
	public List<Article> getArticles() {
		return this.posts; 
	}
	
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
