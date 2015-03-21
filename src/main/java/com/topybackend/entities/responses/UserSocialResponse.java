package com.topybackend.entities.responses;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
@Document(collection = "social")
public class UserSocialResponse extends UserMinimalSocialResponse {

    Map<String, Object> data;

    public UserSocialResponse() {
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
