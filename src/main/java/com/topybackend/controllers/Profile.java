package com.topybackend.controllers;

import com.topybackend.datastores.ProfileRepository;
import com.topybackend.entities.responses.AccountsResponse;
import com.topybackend.entities.responses.GenericBoolResponse;
import com.topybackend.entities.responses.ProfileMinimalResponse;
import com.topybackend.entities.responses.ProfileResponse;
import com.topybackend.services.AccountsHelperService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class Profile {

    @Autowired
    private ProfileRepository profileRepo;

    @Autowired
    private AccountsHelperService accountsHelper;

    /*
        Get profile for given id.
     */
    @RequestMapping(value = "/userservice/profile/")
    public Object getProfile(
            //Requester user id
            @RequestParam(value = "suid", required = true) String suid,
            //User id of interested profile
            @RequestParam(value = "uid", required = true) String uid,
            //Minimal info?
            @RequestParam(value = "minimal", required = false, defaultValue = "true") boolean minimal
    ){
        if(minimal){
            ProfileMinimalResponse profileInfo = new ProfileMinimalResponse();
            AccountsResponse account = accountsHelper.getUserById(uid);
            if(account!=null){
                BeanUtils.copyProperties(account.getMinimalProfile(), profileInfo);
            }

            return profileInfo;
        }
        else{
            ProfileResponse profileInfo = profileRepo.findById(uid);
            if(suid.equals(uid))
                profileInfo.canEdit = true;
            profileInfo.followingsCount = profileInfo.getFollowings().size();
            return profileInfo;
        }
    }

    @RequestMapping(value = "/userservice/profile/secondaryupdate/"/*, method = RequestMethod.POST*/)
    public Object update(
            @RequestParam(value = "suid", required = true) String userId,
            @RequestParam(value = "employed", required = true) boolean employed,
            @RequestParam(value = "job_profile", required = true) int jobProfile,
            @RequestParam(value = "channel", required = true) int channel,
            @RequestParam(value = "drisler", required = false) boolean drisler
    ) {

        ProfileResponse profile = profileRepo.findById(userId);
        List<Integer> channels = new ArrayList<Integer>();
        channels.add(channel);
        profile.setChannel(channels);
        profile.setWorking(employed);
        profile.setJobProfile(jobProfile);
        profile.setDrisler(drisler);
        profileRepo.save(profile);
        return new GenericBoolResponse(true);
    }
}
