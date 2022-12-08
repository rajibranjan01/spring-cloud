package com.example.demo.model;

import javax.persistence.*;

/**
 * @author ActifyDataLabs
 */
@Entity
@Table(name = "ROLES")
public class Role {

	public Role() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Enumerated(EnumType.STRING)

	@Column(name = "NAME")
	private RoleType name;

	public RoleType getName() {
		return name;
	}

	public void setName(RoleType name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
