package com.example.demo.dto;

import java.util.Set;

import com.example.demo.model.Role;

/**
 * @author ActifyDataLabs
 */

public class CurrentUserDTO {

	private String username;
	private Long user_id;
	private String full_name;
	private Set<Role> roles;

	public CurrentUserDTO(String username, Long user_id, String full_name, Set<Role> roles) {
		super();
		this.username = username;
		this.user_id = user_id;
		this.full_name = full_name;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
