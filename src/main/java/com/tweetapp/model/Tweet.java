package com.tweetapp.model;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Tweet {

    private Long tweetId;
    private String contentOfTweet;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createDate;
    private String userIdentityNo;

    public Tweet() {
        createDate = new Date();
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getContentOfTweet() {
        return contentOfTweet;
    }

    public void setContentOfTweet(String contentOfTweet) {
        this.contentOfTweet = contentOfTweet;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserIdentityNo() {
        return userIdentityNo;
    }

    public void setUserIdentityNo(String userIdentityNo) {
        this.userIdentityNo = userIdentityNo;
    }


}
