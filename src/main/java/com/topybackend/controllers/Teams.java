package com.topybackend.controllers;

import com.topybackend.constants.FeedTypes;
import com.topybackend.datastores.FeedsRepository;
import com.topybackend.datastores.TeamsRepository;
import com.topybackend.entities.responses.*;
import com.topybackend.services.AccountsHelperService;
import org.springframework.beans.BeanUtils;
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
public class Teams {

    @Autowired
    private TeamsRepository teamRepo;

    @Autowired
    private FeedsRepository feedRepo;

    @Autowired
    private AccountsHelperService accountsHelper;

    @RequestMapping(value = "/teamservice/profile/")
    public FeedResponse getRecentUpdate(
            @RequestParam(value = "suid", required = true) String suid,
            //User id of interested profile
            @RequestParam("tid") String tid
    ){
        return teamRepo.findById(tid).getRecentUpdate();
    }

    /*
        Get team details for given id.
     */
    @RequestMapping(value = "/teamservice/profile/")
    public Object getTeam(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //User id of interested profile
            @RequestParam("tid") String tid,
            //Minimal info?
            @RequestParam(value = "minimal", required = false, defaultValue = "true") boolean minimal
    ){
        TeamDetailResponse data = teamRepo.findById(tid);
        if(data.getId().isEmpty()){
            return new TeamDetailResponse();
        }
        if(minimal){
            //--todo fix later for minimal api
            TeamMinimalDetailResponse minDetails = new TeamMinimalDetailResponse();
            BeanUtils.copyProperties(data, minDetails);
            return minDetails;
        }
        else{
            return data;
        }
    }


    /*
    Get team details for given id.
 */
    @RequestMapping(value = "/teamservice/create/")
    public Object createTeam(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            @RequestParam("team_name") String teamName
    ) {

        TeamDetailResponse team = new TeamDetailResponse();
        team.setName(teamName);
        team.setFrom_date( (int)(System.currentTimeMillis()/1000L) );
        List<ProfileMinimalResponse> owners = new ArrayList<ProfileMinimalResponse>();
        ProfileMinimalResponse profile = accountsHelper.getUserById(suid).getMinimalProfile();
        owners.add(profile);
        team.setOwners(owners);
        teamRepo.save(team);

        //create a feed
        FeedResponse feed = new FeedResponse();
        feed.setAuthorId(suid);
        feed.setStatus(true);
        feed.setTime((int) (System.currentTimeMillis() / 1000L));
        feed.setTeamId(team.getId());
        feed.setContent("Has joined");
        feed.setType(FeedTypes.NEW_JOIN);
        feedRepo.save(feed);

        team.setRecentUpdate(feed);
        teamRepo.save(team);

        return new GenericBoolResponse(true);
    }

}
