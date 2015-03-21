package com.topybackend.services;

import com.topybackend.entities.responses.TeamMinimalDetailResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 20/03/15.
 */
@Service
public class UserTeamHelperService {

    public List<TeamMinimalDetailResponse> getFollowingTeams(String uid){
        return new ArrayList<TeamMinimalDetailResponse>();
    }
}
