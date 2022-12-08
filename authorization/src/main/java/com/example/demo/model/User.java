package com.example.demo.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author ActifyDataLabs
 */
@Entity
@Table(name = "Users")
public class User {

	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(length = 61)
	private String password;

	@Column
	private String created_by;

	@Column
	private String first_name;

	@Column
	private String last_name;

	@Column
	private String user_type;

	@Column
	private String company_name;

	@Column
	private String phone_number;

	@Column
	private String created_on;

	@Column
	private String modified_on;

	@Column
	private String expiry_date;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "User_ROLES", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getModified_on() {
		return modified_on;
	}

	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}

	public String getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Transient
	public String getAccount_status() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (this.expiry_date.equalsIgnoreCase("1970-01-01")) {
			return "Suspended";
		}
		try {
			date = format.parse(this.expiry_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long timeInMs = date.getTime() + (1000 * 60 * 60 * 24);
		Calendar cal = Calendar.getInstance();
		if (cal.getTimeInMillis() > timeInMs) {
			return "Inactive";
		}
		return "Active";
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", created_by="
				+ created_by + ", first_name=" + first_name + ", last_name=" + last_name + ", user_type=" + user_type
				+ ", company_name=" + company_name + ", phone_number=" + phone_number + ", created_on=" + created_on
				+ ", modified_on=" + modified_on + ", expiry_date=" + expiry_date + ", roles=" + roles + "]";
	}

}
