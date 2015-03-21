package com.topybackend.datastores;

import com.topybackend.entities.responses.ProfileResponse;
import com.topybackend.entities.responses.TeamDetailResponse;
import com.topybackend.entities.responses.TeamMinimalDetailResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prashanth.a on 21/03/15.
 */
public interface TeamsRepository  extends MongoRepository<TeamDetailResponse, String> {
    public TeamDetailResponse findById(String id);
}
