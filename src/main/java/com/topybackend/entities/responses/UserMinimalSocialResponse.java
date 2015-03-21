package com.topybackend.entities.responses;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class UserMinimalSocialResponse {

    String id;
    int type;
    String name;

    public UserMinimalSocialResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserSocialResponse{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
