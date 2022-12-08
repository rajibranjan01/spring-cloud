package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

/**
 * @author ActifyDataLabs
 */
public interface UserService {

	User save(User user);

	List<User> findAll();

	void delete(long id);

	User findByUsername(String username);
}
