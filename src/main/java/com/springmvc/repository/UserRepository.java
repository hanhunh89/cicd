package com.springmvc.repository;

import com.springmvc.domain.User;

public interface UserRepository {
	void createUser(User User);
	User getUser(String userId);
	void deleteUser(String userId);
}
