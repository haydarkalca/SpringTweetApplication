package com.tweetapp.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String identityNo) {
		super(identityNo + ": User identity No cannot be found in the system");
	}

}
