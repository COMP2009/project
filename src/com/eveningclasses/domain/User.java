package com.eveningclasses.domain;

public class User {
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	
	public User(String u, String f, String l, String p) {
		username = u;
		firstName = f;
		lastName = l;
		password = p;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public boolean validatePassword(String password) {
		return this.password.equals(password);
	}
}
