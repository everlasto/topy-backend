package com.topybackend.controllers;

import com.topybackend.entities.StatusCodes;
import com.topybackend.entities.responses.LoginResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class Login {

    /*
        Login authentication
    */
    @RequestMapping("/signin")
    public LoginResponse login(
            //Username
            @RequestParam(value = "name", required = true) String username,
            //Password
            @RequestParam(value = "pass", required = true) String password
    ){
        LoginResponse response = new LoginResponse();
        response.setStatus(StatusCodes.OK);
        if(response.getStatus() == StatusCodes.OK){
            Map<String, Object> userData = new HashMap<String, Object>();
            userData.put("userName", "_username");
            userData.put("userId", "_userid");
            userData.put("userPic", "");
            response.setUserData(userData);
        }
        //--log login status, uid, time
        return response;
    }
}

