package com.topybackend.controllers;

import com.topybackend.entities.responses.ProfileMinimalResponse;
import com.topybackend.entities.responses.ProfileResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class Profile {


    /*
        Get profile for given id.
     */
    @RequestMapping(value = "/profile/")
    public ProfileResponse getProfile(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //User id of interested profile
            @RequestParam("uid") String uid,
            //Minimal info?
            @RequestParam("minimal") Boolean minimal
    ){
        if(minimal){
            //return minimal profile response
            return (ProfileResponse)new ProfileMinimalResponse();
        }
        else{
            if(suid.equals(uid)){
                //account owner request their profile
            }
            //return full profile response
            return new ProfileResponse();
        }
    }


}
