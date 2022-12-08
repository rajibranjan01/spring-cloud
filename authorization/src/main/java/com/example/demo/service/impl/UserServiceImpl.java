package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * @author ActifyDataLabs
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	HttpSession session;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		User user = userDao.findByUsername(userId);
		session.setAttribute("user", user);
		Set grantedAuthorities = getAuthorities(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	private Set getAuthorities(User user) {
		Set<Role> roleByUserId = user.getRoles();
		final Set authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority(role.getName().toString()))
				.collect(Collectors.toSet());
		return authorities;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	
	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}



}
