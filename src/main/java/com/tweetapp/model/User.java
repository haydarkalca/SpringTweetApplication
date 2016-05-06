package com.tweetapp.model;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	
	private String identityNo;
	private String name;
	private String lastName;
	private String userName;
	private Collection<Long> tweets;
	
	public User()
	{
		tweets = new ArrayList<Long>();
	}
	
	public String getIdentityNo() {
		return identityNo;
	}
	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Collection<Long> getTweets() {
		return tweets;
	}
	public void setTweets(Collection<Long> tweets) {
		this.tweets = tweets;
	}
}
