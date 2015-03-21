package com.topybackend.datastores;

import com.topybackend.entities.responses.ProfileResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prashanth.a on 19/03/15.
 */
public interface ProfileRepository  extends MongoRepository<ProfileResponse, String> {
    public ProfileResponse findById(String id);
}
