package com.topybackend.controllers;

import com.topybackend.entities.StatusCodes;
import com.topybackend.entities.responses.GenericBoolResponse;
import com.topybackend.entities.responses.LoginResponse;
import com.topybackend.entities.responses.SignupResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class Signup {

    @RequestMapping(value = "/userservice/signup/verify/")
    /*
        Verify valid username
     */
    public GenericBoolResponse verify(
            //Username
            @RequestParam(value = "name", required = true) String username
    ){
        return new GenericBoolResponse(true);
    }

    /*
        Create account
     */
    @RequestMapping(value = "/userservice/signup/add/"/*, method = RequestMethod.POST*/)
    public SignupResponse signup(
            //Username
            @RequestParam(value = "name", required = true) String username,
            //Password
            @RequestParam(value = "pass", required = true) String password,
            //Social Data (linkedin)
            @RequestParam(value = "linkedInSocialData", required = true) String socialData
    ){
        SignupResponse response = new SignupResponse();
        response.setStatus(StatusCodes.OK);
        if(response.getStatus() == StatusCodes.OK){
            response.setUser_name("_username");
            response.setUser_id("_id");
            response.setUser_pic("_pic");
            //decode linkedInSocialData to linkedinsocialresponse
        }
        //--log acct creation, id, name, time
        return response;
    }

}
