package com.topybackend.controllers;

import com.topybackend.entities.StatusCodes;
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

    @RequestMapping(value = "/signup/verify/")

    /*
        Verify valid username
     */
    public Boolean verify(
            //Username
            @RequestParam("name") String username
    ){
        return false;
    }

    /*
        Create account
     */
    @RequestMapping(value = "/signup/add/"/*, method = RequestMethod.POST*/)
    public SignupResponse signup(
            //Username
            @RequestParam(value = "name", required = true) String username,
            //Password
            @RequestParam(value = "pass", required = true) String password,
            //Social Data (linkedin)
            @RequestParam(value = "socialData", required = true) String socialData
    ){
        SignupResponse response = new SignupResponse();
        response.setStatus(StatusCodes.OK);
        if(response.getStatus() == StatusCodes.OK){
            Map<String, Object> userData = new HashMap<String, Object>();
            userData.put("userName", "_username");
            userData.put("userId", "_userid");
            userData.put("userPic", "");
            response.setUserData(userData);
        }
        //--log acct creation, id, name, time
        return response;
    }

    private int userStatus(String status){
        return 0;
    }

}
