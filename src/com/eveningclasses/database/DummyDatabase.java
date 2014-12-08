package com.eveningclasses.database;

import java.util.HashMap;
import java.util.Map;

import com.eveningclasses.domain.User;

public class DummyDatabase {
	Map<String, User> users = new HashMap<>();
	
	public void initWithDefaultData() {
		User user = new User("user", "Pat", "Smith", "password");
		createUser(user);
	}
	public User getUserByUsername(String username) {
		if(users.containsKey(username)) {
			return users.get(username);
		}
		return null;
	}
	
	public void createUser(User user) {
		users.put(user.getUsername(), user);
	}
}
