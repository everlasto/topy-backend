package com.topybackend.entities.responses;

import com.topybackend.constants.StatusCodes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Created by prashanth.a on 18/03/15.
 */
@Document(collection = "accounts")
public class AccountsResponse {

    int status;

    @NotNull
    @Indexed(unique=true)
    String userName;

    @NotNull
    String passWord;

    @Id
    String userId;

    ProfileMinimalResponse minimalProfile;

    public AccountsResponse() {
        status = StatusCodes.UNKNOWN;
        minimalProfile = new ProfileMinimalResponse();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ProfileMinimalResponse getMinimalProfile() {
        return minimalProfile;
    }

    public void setMinimalProfile(ProfileMinimalResponse minimalProfile) {
        this.minimalProfile = minimalProfile;
    }

    public String getPassWord() {
        /*return passWord;*/
        return "***";
    }

    public String getPassWord(boolean getReal){
        return getReal?passWord:"***";
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "AccountsResponse{" +
                "status=" + status +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userId='" + userId + '\'' +
                ", minimalProfile=" + minimalProfile +
                '}';
    }
}
