package com.topybackend.entities.responses;

import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class ProfileMinimalResponse {

    String name;
    String picture;
    List<TeamMinimalDetailResponse> currentTeams;
    int followings_count;

    public ProfileMinimalResponse() {}

    public List<TeamMinimalDetailResponse> getCurrentTeams() {
        return currentTeams;
    }

    public void setCurrentTeams(List<TeamMinimalDetailResponse> currentTeams) {
        this.currentTeams = currentTeams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getFollowings_count() {
        return followings_count;
    }

    public void setFollowings_count(int followings_count) {
        this.followings_count = followings_count;
    }
}
