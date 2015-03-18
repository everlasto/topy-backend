package com.topybackend.entities.responses;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class LoginResponse {
    int status;
    String user_name;
    String user_id;
    String user_pic;

    public LoginResponse() {
        status = -3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }
}
