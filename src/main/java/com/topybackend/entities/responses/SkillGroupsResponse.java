package com.topybackend.entities.responses;

import java.util.List;
import org.springframework.data.annotation.Id;

/**
 * Created by prashanth.a on 21/03/15.
 */
public class SkillGroupsResponse {
    @Id
    String id;
    String description;
    String name;
    List<String> childSkillsId;

    public SkillGroupsResponse() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChildSkillsId() {
        return childSkillsId;
    }

    public void setChildSkillsId(List<String> childSkillsId) {
        this.childSkillsId = childSkillsId;
    }
}
