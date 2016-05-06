package com.tweetapp.exception;

public class TweetNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TweetNotFoundException(Long tweetId) {
		super(tweetId + ": Tweet cannot be found in the system");
	}
}
