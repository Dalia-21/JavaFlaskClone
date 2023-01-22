package dalia.javablog.sqlitedb;

public class User {
	private int id;
	private String username;
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void printUser() {
		System.out.println(String.format("User with id : %d", id));
		System.out.println(String.format("Username: %s", username));
	}
	
}
