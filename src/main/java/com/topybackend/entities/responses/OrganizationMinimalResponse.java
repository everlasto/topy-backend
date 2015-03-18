package com.topybackend.entities.responses;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class OrganizationMinimalResponse {
    String id;
    String name;
    String link;

    public OrganizationMinimalResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
