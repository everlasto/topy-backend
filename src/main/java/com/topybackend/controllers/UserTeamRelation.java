package com.topybackend.controllers;

import com.topybackend.entities.responses.FeedResponse;
import com.topybackend.entities.responses.TeamMinimalDetailResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class UserTeamRelation {

    /*
        Follow/Unfollow a team
     */
    @RequestMapping(value = "/userteamservice/follow/")
    public Boolean followUnfollow(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting team id
            @RequestParam(value = "tid", required = true) String tid,
            //Did user request for follow or unfollow?
            @RequestParam(value = "unfollow") Boolean isUnfollow
    ){
        return false;
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
    public Boolean isFollow(
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
        return null;
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
