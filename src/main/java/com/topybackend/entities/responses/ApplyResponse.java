package com.topybackend.entities.responses;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class ApplyResponse {
    boolean okay;
    String description;

    public boolean isOkay() {
        return okay;
    }

    public void setOkay(boolean okay) {
        this.okay = okay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplyResponse() {
    }
}
