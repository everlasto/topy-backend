package com.topybackend.entities.responses;

import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class ProfileMinimalResponse {

    String id;
    String name;
    String picture;
    boolean working;
    int jobProfile;
    boolean drisler;
    List<TeamMinimalDetailResponse> currentTeams;

    @Transient
    public int followingsCount;

    public ProfileMinimalResponse() {}

    //Copy constructor
    public ProfileMinimalResponse(ProfileResponse p) {
        id = p.getId();
        name = p.getName();
        picture = p.getPicture();
        currentTeams = p.getCurrentTeams();
        followingsCount = p.getFollowings().size();
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProfileMinimalResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", currentTeams=" + currentTeams +
                '}';
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public int getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(int jobProfile) {
        this.jobProfile = jobProfile;
    }

    public boolean isDrisler() {
        return drisler;
    }

    public void setDrisler(boolean drisler) {
        this.drisler = drisler;
    }
}
