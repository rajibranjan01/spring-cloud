package com.example.demo;

import java.util.List;

/**
 * @author ActifyDataLabs
 */
public interface UserService {

	User save(User user);

	List<User> findAll();

	void delete(long id);

	User findByUsername(String username);
}
