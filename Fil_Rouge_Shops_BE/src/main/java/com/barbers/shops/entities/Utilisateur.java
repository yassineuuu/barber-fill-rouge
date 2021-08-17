package com.barbers.shops.entities;




public class Utilisateur {
	

	private long id;
	private String userId;
	private String username;
	private String email;
	private String password;
	private String role;
	
	public Utilisateur(long id, String userId, String username, String email, String password, String role) {
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Utilisateur(String userId, String username, String email, String password, String role) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Utilisateur() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", userId=" + userId + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	

}
