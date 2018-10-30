package com.java.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.entity.User;

public interface UserDao extends MongoRepository<User, String> {

	public User findByUsername(String username);
}
