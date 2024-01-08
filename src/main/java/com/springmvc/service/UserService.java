package com.springmvc.service;
import com.springmvc.domain.User;

public interface UserService {
	void createUser(User user);
	User getUser(String userId);
	void deleteUser(String userId);
}

