package com.topybackend.controllers;

import com.topybackend.entities.responses.ProfileMinimalResponse;
import com.topybackend.entities.responses.ProfileResponse;
import com.topybackend.entities.responses.TeamDetailResponse;
import com.topybackend.entities.responses.TeamMinimalDetailResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class Teams {

    /*
        Get team details for given id.
     */
    @RequestMapping(value = "/profile/")
    public TeamDetailResponse getTeam(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //User id of interested profile
            @RequestParam("tid") String tid,
            //Minimal info?
            @RequestParam("minimal") Boolean minimal
    ){
        if(minimal){
            //return minimal team response
            return (TeamDetailResponse)new TeamMinimalDetailResponse();
        }
        else{
            //return full team response
            return new TeamDetailResponse();
        }
    }

}
