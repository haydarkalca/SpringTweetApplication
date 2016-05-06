package com.tweetapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.User;
import com.tweetapp.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> getUsers() {
		return new ResponseEntity<Collection<User>>(userService.getAllUsers(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "identityNo" })
	public ResponseEntity<User> getUserbyId(@RequestParam String identityNo) {
		return new ResponseEntity<User>(userService.getUserbyId(identityNo),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.registerUser(user),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, params = { "identityNo" })
	public ResponseEntity<User> updateUser(@RequestParam String identityNo,
			@RequestBody User user) {
		return new ResponseEntity<User>(
				userService.updateUser(identityNo, user), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, params = { "identityNo" })
	public ResponseEntity<Boolean> deleteUser(@RequestParam String identityNo) {
		return new ResponseEntity<Boolean>(
				userService.deleteUserbyId(identityNo), HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllUsers() {
		userService.deleteAllUsers();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
