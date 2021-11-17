package blog.models;

public class Article {
	
	private String title;
	private String content;
	private User user;
	public Article(String title, String content, User user) {
		this.setContent(content);
		this.setTitle(title);
		this.setUser(user);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
