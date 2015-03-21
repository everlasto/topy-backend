package com.topybackend.controllers;

import com.topybackend.datastores.AccountsRepository;
import com.topybackend.datastores.FeedsRepository;
import com.topybackend.entities.responses.FeedResponse;
import com.topybackend.entities.responses.FollowResponse;
import com.topybackend.entities.responses.HomeFeedResponse;
import com.topybackend.entities.responses.TeamMinimalDetailResponse;
import com.topybackend.services.UserTeamHelperService;
import com.topybackend.utils.ListHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class Feeds {

    @Autowired
    private FeedsRepository feedsRepo;

    @Autowired
    private UserTeamHelperService userTeamHelper;

    /*
    Get feed data for given feed id.
     */
    @RequestMapping(value = "/feedservice/feed/")
    public FeedResponse getFeed(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting feed-id
            @RequestParam(value = "fid", required = true) String fid
    ){
        FeedResponse feed = feedsRepo.findOne(fid);
        if(feed!=null){
            String author =  feed.getAuthorId();
            //--todo check if author is permitted to see this
            //--todo use repo to fetch team data
            TeamMinimalDetailResponse teamData = new TeamMinimalDetailResponse();
            teamData.setId(feed.getTeamId());
            teamData.setName("yyyy");
            feed.setTeamDetail(teamData);

            //--todo if user belongs to team that created this feed/ user is author allow to edit.
            feed.setCanEdit(false);
        }
        return feed;
    }

    /*
    Get home page feeds.
    */
    @RequestMapping(value = "/feedservice/feed/home/")
    public HomeFeedResponse getHomeFeed(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Exclude feed ids.
            @RequestParam(value = "x_fids", required = false) String[] exclude_fids
    ){
        List<TeamMinimalDetailResponse> following = userTeamHelper.getFollowingTeams(suid);

        HomeFeedResponse response = new HomeFeedResponse();
        //--todo implement exclude fids
        //--todo improve this method for god sake.
        if(following.isEmpty()) {
            //get top 10 feeds sorted by time in descending
            response.setFeeds(feedsRepo.findTop10ByOrderByTimeDesc());
        }
        else{
            List<FeedResponse> feeds= new ArrayList<FeedResponse>();
            for(TeamMinimalDetailResponse team: following){
                List<FeedResponse> top10teamFeeds = feedsRepo.findByTeamId(team.getId());
                for(FeedResponse feed: top10teamFeeds){
                    feeds.add(feed);
                }
            }
            response.setFeeds(feeds);
        }
        return response;
    }

    /*
        Save feed posted by given user within a team.
    */
    @RequestMapping(value = "/feedservice/feed/create/" /*, method = RequestMethod.POST*/)
    public FeedResponse saveFeed(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //Requesting team-id
            @RequestParam(value = "tid", required = true) String tid,
            //Requesting team-id
            @RequestParam(value = "content", required = true) String content,
            //Requesting team-id
            @RequestParam(value = "type", required = true) int type,
            //Requesting team-id
            @RequestParam(value = "media", required = false) String media
    ) {
        if(suid.isEmpty() || tid.isEmpty()){
            return new FeedResponse();
        }
        //--todo check if proper suid.
        //--todo check if suid belongs to tid.
        FeedResponse feed = new FeedResponse();
        feed.setType(type);
        feed.setAuthorId(suid);
        feed.setContent(content);
        feed.setStatus(true);
        //--todo make other statuses as is_status as false.
        feed.setLikes(0);
        feed.setTeamId(tid);
        //--todo set media, media should be separate entity.

        //likes will not be tracked. but to track user liked it or not we need separate likes table.

        feed.setTime((int)(System.currentTimeMillis() / 1000L));
        feedsRepo.save(feed);
        if(!feed.getId().isEmpty()){
            return feed;
        }
        else{
            return new FeedResponse();
        }
    }
}
