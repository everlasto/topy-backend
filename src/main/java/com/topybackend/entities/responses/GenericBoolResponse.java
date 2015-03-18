package com.topybackend.entities.responses;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class GenericBoolResponse {
    boolean flag;

    public GenericBoolResponse(boolean b) {
        flag = b;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean response) {
        this.flag = response;
    }
}
