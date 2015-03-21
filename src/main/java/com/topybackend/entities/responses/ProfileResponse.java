package com.topybackend.entities.responses;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
@Document(collection = "profiles")
public class ProfileResponse extends ProfileMinimalResponse{

    List<TeamMinimalDetailResponse> pastTeams;
    List<SkillsResponse> skills;
    List<SkillGroupsResponse> skillGroups;
    List<Integer> channel;

    List<TeamMinimalDetailResponse> followings;
    List<TeamMinimalDetailResponse> applications;
    UserMinimalSocialResponse linkedInData;

    public ProfileResponse() {
        pastTeams = new ArrayList<TeamMinimalDetailResponse>();
        skills = new ArrayList<SkillsResponse>();
        followings = new ArrayList<TeamMinimalDetailResponse>();
        applications = new ArrayList<TeamMinimalDetailResponse>();
    }

    public UserMinimalSocialResponse getLinkedInData() {
        return (UserMinimalSocialResponse)linkedInData;
    }

    public void setLinkedInData(UserMinimalSocialResponse linkedInData) {
        this.linkedInData = linkedInData;
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

    @Override
    public String toString() {
        return "ProfileResponse{" +
                "pastTeams=" + pastTeams +
                ", skills=" + skills +
                ", followings=" + followings +
                ", applications=" + applications +
                ", linkedInData=" + linkedInData +
                '}';
    }

    public List<SkillGroupsResponse> getSkillGroups() {
        return skillGroups;
    }

    public void setSkillGroups(List<SkillGroupsResponse> skillGroups) {
        this.skillGroups = skillGroups;
    }

    public List<Integer> getChannel() {
        return channel;
    }

    public void setChannel(List<Integer> channel) {
        this.channel = channel;
    }

    @Transient
    public boolean canEdit = false;

}
