package com.topybackend.controllers;

import com.topybackend.entities.responses.FeedResponse;
import com.topybackend.entities.responses.HomeFeedResponse;
import com.topybackend.entities.responses.ProfileResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by prashanth.a on 18/03/15.
 */
public class Feeds {

    /*
    Get feed data for given feed id.
     */
    @RequestMapping(value = "/feed/")
    public FeedResponse getFeed(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting feed-id
            @RequestParam(value = "fid", required = true) String fid
    ){
        return new FeedResponse();
    }

    /*
    Get home page feeds.
     */
    @RequestMapping(value = "/feed/home/")
    public HomeFeedResponse getHomeFeed(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Exclude feed ids.
            @RequestParam(value = "fids", required = false) String[] fids
    ){
        return new HomeFeedResponse();
    }


}
