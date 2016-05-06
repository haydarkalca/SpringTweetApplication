package com.tweetapp.serviceImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import org.springframework.stereotype.Service;

import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.model.User;
import com.tweetapp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private static final Map<String, User> users = new HashMap<String, User>();

	public Collection<User> getAllUsers() {
		return users.values();
	}

	public User getUserbyId(String id) {
		validateExistingUser(id);
		return users.get(id);
	}

	public User registerUser(User user) {
		String identityNo = generateIdentityNo();
		user.setIdentityNo(identityNo);
		users.put(identityNo, user);
		return users.get(identityNo);
	}

	public Boolean deleteUserbyId(String id) {
		validateExistingUser(id);
		return users.remove(id) != null;
	}

	public User updateUser(String id, User user) {
		validateExistingUser(id);
		User currentUser = users.get(id);
		currentUser.setName(user.getName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUserName(user.getUserName());
		return currentUser;
	}

	public void  deleteAllUsers()
	{
		users.clear();
	}
	
	public String generateIdentityNo() {
		Vector<Integer> array = new Vector<Integer>();
		Random randomGenerator = new Random();
		String res = "";
		int t1 = 0;
		int t2 = 0;
		array.add(new Integer(1 + randomGenerator.nextInt(9)));
		for (int i = 1; i < 9; i++)
			array.add(randomGenerator.nextInt(10));
		for (int i = 0; i < 9; i += 2)
			t1 += array.elementAt(i);
		for (int i = 1; i < 8; i += 2)
			t2 += array.elementAt(i);
		int x = (t1 * 7 - t2) % 10;
		array.add(new Integer(x));
		x = 0;
		for (int i = 0; i < 10; i++)
			x += array.elementAt(i);
		x = x % 10;
		array.add(new Integer(x));
		for (int i = 0; i < 11; i++)
			res = res + Integer.toString(array.elementAt(i));
		return res;
	}
	
	public void validateExistingUser(String id)
	{
		if (users.get(id)==null)
				throw new UserNotFoundException(id);
	}
}
