package com.topybackend.entities.responses;


import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class TeamMinimalDetailResponse {

    String id;
    String name;
    FeedResponse recent_update;
    //needed though we have list of followers
    int followers_count;
    int members_count;

    public TeamMinimalDetailResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeedResponse getRecent_update() {
        return recent_update;
    }

    public void setRecent_update(FeedResponse recent_update) {
        this.recent_update = recent_update;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getMembers_count() {
        return members_count;
    }

    public void setMembers_count(int members_count) {
        this.members_count = members_count;
    }
}
