package com.example.demo;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ActifyDataLabs
 */
@RestController
public class UserController {

	@Autowired
	TokenStore tokenStore;

	@Autowired
	private DefaultTokenServices tokenServices;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public CurrentUserDTO getuser(Principal user) {
		final OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		User userDetails = userService.findByUsername(auth.getName());
		return new CurrentUserDTO(userDetails.getUsername(), userDetails.getUser_id(), userDetails.getFirst_name(),
				userDetails.getRoles());
	}

//	@RequestMapping(value = "/lastLoginDetails", method = RequestMethod.GET)
//	public String getLastloginDeatils(@QueryParam(value = "userType") String userType, Principal princUser)
//			throws SQLException {
//		String response = null;
//		response = userLoginInfoService.getLastLoginDeatils(princUser.getName(), userType.toUpperCase());
//		return response;
//	}
//
//	@RequestMapping(value = "/shareUsers", method = RequestMethod.GET)
//	public List<UserDTO> getShareUsers(Principal user) {
//		List<User> users = userService.getShareUsers(user.getName());
//
//		return users.stream().map(b -> new UserDTO(b.getUsername(), b.getUser_id(), b.getFull_name(), b.getCreated(),
//				b.getExpiry_date(), b.getRoles())).collect(Collectors.toList());
//	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return "success";
	}

	@DeleteMapping("/logout")
	public void revokeToken(@RequestHeader("Authorization") String token, String refreshToken) {
		String accessToken = token.replaceAll("Bearer", "").replaceAll(" ", "");
		final OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		tokenServices.revokeToken(accessToken);
	}

}
