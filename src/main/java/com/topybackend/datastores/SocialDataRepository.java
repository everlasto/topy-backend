package com.topybackend.datastores;

import com.topybackend.entities.responses.UserSocialResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prashanth.a on 19/03/15.
 */
public interface SocialDataRepository  extends MongoRepository<UserSocialResponse, String> {
}
