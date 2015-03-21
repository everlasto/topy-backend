package com.topybackend.entities.responses;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
@Document(collection = "teams")
public class TeamDetailResponse extends TeamMinimalDetailResponse {

    int from_date;
    int to_date;
    List<ProfileMinimalResponse> owners;
    //List<SkillGroups>
    List<ProfileMinimalResponse> members;
    List<FeedResponse> updates;
    //int likes;
    List<ProfileMinimalResponse> followers;
    List<ProfileMinimalResponse> applicants;
    OrganizationMinimalResponse organization;
    //List<RequirementSkills>
    List<BadgeResponse> badges;

    public TeamDetailResponse() {
        members = new ArrayList<ProfileMinimalResponse>();
    }

    public int getFrom_date() {
        return from_date;
    }

    public void setFrom_date(int from_date) {
        this.from_date = from_date;
    }

    public int getTo_date() {
        return to_date;
    }

    public void setTo_date(int to_date) {
        this.to_date = to_date;
    }

    public List<ProfileMinimalResponse> getOwners() {
        return owners;
    }

    public void setOwners(List<ProfileMinimalResponse> owners) {
        this.owners = owners;
    }

    public List<ProfileMinimalResponse> getMembers() {
        return members;
    }

    public void setMembers(List<ProfileMinimalResponse> members) {
        this.members = members;
    }

    public List<FeedResponse> getUpdates() {
        return updates;
    }

    public void setUpdates(List<FeedResponse> updates) {
        this.updates = updates;
    }

    public List<ProfileMinimalResponse> getFollowers() {
        return followers;
    }

    public void setFollowers(List<ProfileMinimalResponse> followers) {
        this.followers = followers;
    }

    public List<ProfileMinimalResponse> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<ProfileMinimalResponse> applicants) {
        this.applicants = applicants;
    }

    public OrganizationMinimalResponse getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationMinimalResponse organization) {
        this.organization = organization;
    }

    public List<BadgeResponse> getBadges() {
        return badges;
    }

    public void setBadges(List<BadgeResponse> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "TeamDetailResponse{" +
                "from_date=" + from_date +
                ", to_date=" + to_date +
                ", owners=" + owners +
                ", members=" + members +
                ", updates=" + updates +
                ", followers=" + followers +
                ", applicants=" + applicants +
                ", organization=" + organization +
                ", badges=" + badges +
                '}';
    }

    @Transient
    public boolean isMinimal = false;
    @Transient
    public boolean canEdit = false;

}
