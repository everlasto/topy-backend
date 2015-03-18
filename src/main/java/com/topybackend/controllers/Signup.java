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

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public SignupResponse signup(
            @RequestParam(value = "name", required = true) String username,
            @RequestParam(value = "pass", required = true) String password,
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

}
