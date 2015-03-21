package com.topybackend.controllers;

import com.topybackend.datastores.ProfileRepository;
import com.topybackend.datastores.TeamsRepository;
import com.topybackend.entities.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class UserTeamRelation {

    @Autowired
    private ProfileRepository profileRepo;

    @Autowired
    private TeamsRepository teamRepo;

    /*
        Follow/Unfollow a team
     */
    @RequestMapping(value = "/userteamservice/follow/")
    public Object followUnfollow(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting team id
            @RequestParam(value = "tid", required = true) String tid,
            //Did user request for follow or unfollow?
            @RequestParam(value = "unfollow") Boolean isUnfollow
    ){
        //should update sessions once at client.
        ProfileResponse profile = profileRepo.findById(suid);
        List<TeamMinimalDetailResponse> followings = profile.getFollowings();
        for(TeamMinimalDetailResponse team: followings){
            if(team.getId().equals(tid)){
                return new GenericBoolResponse(true);
            }
        }
        TeamMinimalDetailResponse team = teamRepo.findById(tid);
        if(team!=null && !team.getId().isEmpty()){
            followings.add(team);
            profile.setFollowings(followings);
            profileRepo.save(profile);
            return new GenericBoolResponse(true);
        }
        return new GenericBoolResponse(false);
    }

    /*
        Apply/UnApply for a team
     */
    @RequestMapping(value = "/userteamservice/apply/")
    public Boolean applyUnapply(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting team id
            @RequestParam(value = "tid", required = true) String tid,
            //Did user request for apply or unapply?
            @RequestParam(value = "unapply") Boolean isUnapply
    ){
        return false;
    }

    /*
        Is given user following?
     */
    @RequestMapping(value = "/userteamservice/isFollow/")
    public Object isFollow(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting team id
            @RequestParam(value = "tid", required = true) String tid
    ){
        ProfileResponse profile = profileRepo.findById(suid);
        List<TeamMinimalDetailResponse> followings = profile.getFollowings();
        for(TeamMinimalDetailResponse team: followings){
            if(team.getId().equals(tid)){
                return new GenericBoolResponse(true);
            }
        }
        return new GenericBoolResponse(false);
    }

    /*
        Is given user applied?
     */
    @RequestMapping(value = "/userteamservice/isApplied/")
    public Boolean isApplied(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting team id
            @RequestParam(value = "tid", required = true) String tid
    ){
        return false;
    }

    /*
    Is given user applied?
 */
    @RequestMapping(value = "/userteamservice/followings/")
    public List<TeamMinimalDetailResponse> followedTeams(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid
    ){
        ProfileResponse profile = profileRepo.findById(suid);
        return profile.getFollowings();
    }

    /*
    Is given user applied?
 */
    @RequestMapping(value = "/userteamservice/applications/")
    public List<TeamMinimalDetailResponse> appliedTeams(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid
    ){
        return null;
    }

}
