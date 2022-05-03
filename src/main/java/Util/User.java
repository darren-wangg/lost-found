package Util;

public class User {
	private String email;
	private String name;
	private String id;
	private String username;
	private String password;
	
	public User(String name_, String email_, String id_, String username_, String password_) {
		name = name_;
		email = email_;
		password = password_;
		id = id_;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}