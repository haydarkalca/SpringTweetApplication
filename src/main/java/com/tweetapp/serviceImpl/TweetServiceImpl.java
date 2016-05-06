package com.tweetapp.serviceImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.exception.TweetNotFoundException;
import com.tweetapp.model.Tweet;
import com.tweetapp.service.ITweetService;

@Service
public class TweetServiceImpl implements ITweetService {

    private static final Map<Long, Tweet> tweets = new HashMap<Long, Tweet>();
    private static long tweetIdCount = 1;

    @Autowired
    UserServiceImpl userService;

    public Collection<Tweet> getAllTweets() {
        return tweets.values();
    }

    public Collection<Tweet> getAllTweetsOfGivenUser(String userIdentityNo) {
        userService.validateExistingUser(userIdentityNo);
        Map<Long, Tweet> tweetsOfGivenUser = new HashMap<Long, Tweet>();
        Collection<Long> tweetIdsOfUser = userService.getUserbyId(userIdentityNo).getTweets();
        for (Long tweetId : tweetIdsOfUser)
            tweetsOfGivenUser.put(tweetId, tweets.get(tweetId));
        return tweetsOfGivenUser.values();
    }

    public Tweet createTweet(String userIdentityNo, Tweet tweet) {
        userService.validateExistingUser(userIdentityNo);
        long tweetId = generateTweetId();
        tweet.setTweetId(tweetId);
        tweet.setUserIdentityNo(userIdentityNo);
        tweets.put(tweetId, tweet);
        userService.getUserbyId(userIdentityNo).getTweets().add(tweetId);
        return tweets.get(tweetId);

    }

    public Tweet updateTweet(Long tweetId, Tweet tweet) {
        validateExistingTweet(tweetId);
        Tweet currentTweet = tweets.get(tweetId);
        currentTweet.setCreateDate(tweet.getCreateDate());
        currentTweet.setContentOfTweet(tweet.getContentOfTweet());
        currentTweet.setUserIdentityNo(tweet.getUserIdentityNo());
        return currentTweet;
    }

    public Boolean deleteTweet(Long tweetId) {
        validateExistingTweet(tweetId);
        userService.getUserbyId(tweets.get(tweetId).getUserIdentityNo())
                .getTweets().remove(tweetId);
        return tweets.remove(tweetId) != null;
    }

    public long generateTweetId() {
        return ++tweetIdCount;
    }

    public void validateExistingTweet(long tweetId) {
        if (tweets.get(tweetId) == null)
            throw new TweetNotFoundException(tweetId);
    }
}
