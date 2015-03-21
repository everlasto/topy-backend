package com.topybackend.datastores;

import com.topybackend.entities.responses.AccountsResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by prashanth.a on 18/03/15.
 */
public interface AccountsRepository extends MongoRepository<AccountsResponse, String> {
    public AccountsResponse findByUserName(String userName);
    public AccountsResponse findByUserId(String userId);
}
