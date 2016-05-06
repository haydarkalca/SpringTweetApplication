package com.tweetapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Tweet;
import com.tweetapp.service.ITweetService;

@RestController
@RequestMapping(value = "/tweets")
public class TweetController {

	@Autowired
	private ITweetService tweetService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Collection<Tweet> getAllTweets() {
		return tweetService.getAllTweets();
	}

	@RequestMapping(method = RequestMethod.GET, params = "identityNo")
	@ResponseStatus(HttpStatus.OK)
	public Collection<Tweet> getAllTweetsOfUser(@RequestParam String identityNo) {
		return tweetService.getAllTweetsOfGivenUser(identityNo);
	}

	@RequestMapping(method = RequestMethod.POST, params = "identityNo")
	@ResponseStatus(HttpStatus.CREATED)
	public Tweet createTweet(@RequestParam String identityNo,
			@RequestBody Tweet tweet) {
		return tweetService.createTweet(identityNo, tweet);
	}

	@RequestMapping(method = RequestMethod.PUT, params = "tweetId")
	@ResponseStatus(HttpStatus.OK)
	public Tweet updateTweet(@RequestParam Long tweetId,
			@RequestBody Tweet tweet) {
		return tweetService.updateTweet(tweetId, tweet);
	}

	@RequestMapping(method = RequestMethod.DELETE, params = "tweetId")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Boolean deleteTweet(@RequestParam Long tweetId) {
		return tweetService.deleteTweet(tweetId);
	}
}
