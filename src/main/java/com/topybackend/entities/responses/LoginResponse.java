package com.topybackend.entities.responses;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class LoginResponse {
    int status;
    Map<String, Object> userData;

    public LoginResponse() {
        userData = new HashMap<String, Object>();
        status = -3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }
}
