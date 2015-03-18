package com.topybackend.entities.responses;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class UserSocialResponse {

    String id;
    String type;
    String name;

    public UserSocialResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
