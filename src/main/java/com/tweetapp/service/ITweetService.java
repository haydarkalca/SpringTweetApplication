package com.tweetapp.service;

import java.util.Collection;
import org.springframework.stereotype.Service;
import com.tweetapp.model.Tweet;

@Service
public interface ITweetService {
	
  Collection<Tweet> getAllTweets();
  Collection<Tweet> getAllTweetsOfGivenUser(String userIdentityNo);  
  Tweet createTweet(String userIdentityNo,Tweet tweet);
  Tweet updateTweet(Long tweetId ,Tweet tweet);
  Boolean deleteTweet(Long tweetId);
}
