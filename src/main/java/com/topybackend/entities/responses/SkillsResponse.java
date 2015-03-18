package com.topybackend.entities.responses;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class SkillsResponse {

    int skill_id;
    String skill_name;
    int type;

    public SkillsResponse() {
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
