package com.topybackend.entities.responses;

import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class HomeFeedResponse {

    List<FeedResponse> feeds;

    public HomeFeedResponse() {
    }

    public List<FeedResponse> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedResponse> feeds) {
        this.feeds = feeds;
    }
}
