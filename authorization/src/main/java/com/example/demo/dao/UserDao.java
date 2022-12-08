package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

/**
 * @author ActifyDataLabs
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);

	@Query("select user from User user where user.username like CONCAT('%',:domainName)")
	List<User> findAllDomainUsers(@Param("domainName") String domainName);
	User findById(long user_id);
}
