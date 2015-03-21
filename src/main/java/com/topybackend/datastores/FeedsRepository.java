package com.topybackend.datastores;

import com.topybackend.entities.responses.FeedResponse;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by prashanth.a on 20/03/15.
 */
public interface FeedsRepository extends MongoRepository<FeedResponse, String> {
    public List<FeedResponse> findTop10ByOrderByTimeDesc();
    public List<FeedResponse> findByTeamId(String teamId);
}
