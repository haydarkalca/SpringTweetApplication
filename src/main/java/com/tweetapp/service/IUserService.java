package com.tweetapp.service;

import java.util.Collection;
import org.springframework.stereotype.Service;
import com.tweetapp.model.User;

@Service
public interface IUserService {
	
	Collection<User> getAllUsers();
	User getUserbyId (String id);
	User registerUser (User user);
	Boolean deleteUserbyId (String id);
	User updateUser(String id ,User user);
	void deleteAllUsers();
}