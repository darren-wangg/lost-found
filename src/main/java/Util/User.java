package Util;

public class User {
	private String email;
	private String id;
	private String username;
	private String password;
	
	public User(String email_, String username_, String password_) {
		email = email_;
		password = password_;
		username = username_;
		
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
