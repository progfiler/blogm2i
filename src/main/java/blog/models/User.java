package blog.models;

public class User {
	
	private String username;
	private int nbrPost; 
	private String email;
	private String role;
	
	public User(String username, int nbrPost, String email, String role) {
		this.setUsername(username);
		this.setEmail(email);
		this.setNbrPost(nbrPost);
		this.setRole(role);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getNbrPost() {
		return nbrPost;
	}

	public void setNbrPost(int nbrPost) {
		this.nbrPost = nbrPost;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
