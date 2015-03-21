package com.topybackend.entities.responses;


import java.util.List;
import org.springframework.data.annotation.Id;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class TeamMinimalDetailResponse {

    @Id
    String id;
    String name;
    FeedResponse recentUpdate;
    //needed though we have list of followers
    int followersCount;
    int membersCount;

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

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(int membersCount) {
        this.membersCount = membersCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public FeedResponse getRecentUpdate() {
        return recentUpdate;
    }

    public void setRecentUpdate(FeedResponse recentUpdate) {
        this.recentUpdate = recentUpdate;
    }

    @Override
    public String toString() {
        return "TeamMinimalDetailResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

