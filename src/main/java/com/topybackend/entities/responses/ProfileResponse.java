package com.topybackend.entities.responses;

import java.util.List;
import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class ProfileResponse extends ProfileMinimalResponse{

    Map<String, Object> socialIDS;

    List<TeamMinimalDetailResponse> pastTeams;
    List<SkillsResponse> skills;
    List<TeamMinimalDetailResponse> followings;
    List<TeamMinimalDetailResponse> applications;

    public ProfileResponse() {
    }

    public Map<String, Object> getSocialIDS() {
        return socialIDS;
    }

    public void setSocialIDS(Map<String, Object> socialIDS) {
        this.socialIDS = socialIDS;
    }

    public List<TeamMinimalDetailResponse> getPastTeams() {
        return pastTeams;
    }

    public void setPastTeams(List<TeamMinimalDetailResponse> pastTeams) {
        this.pastTeams = pastTeams;
    }

    public List<SkillsResponse> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsResponse> skills) {
        this.skills = skills;
    }

    public List<TeamMinimalDetailResponse> getFollowings() {
        return followings;
    }

    public void setFollowings(List<TeamMinimalDetailResponse> followings) {
        this.followings = followings;
    }

    public List<TeamMinimalDetailResponse> getApplications() {
        return applications;
    }

    public void setApplications(List<TeamMinimalDetailResponse> applications) {
        this.applications = applications;
    }
}
