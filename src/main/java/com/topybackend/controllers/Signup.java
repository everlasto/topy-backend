package com.topybackend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topybackend.constants.Types;
import com.topybackend.datastores.AccountsRepository;
import com.topybackend.constants.StatusCodes;
import com.topybackend.datastores.ProfileRepository;
import com.topybackend.datastores.SocialDataRepository;
import com.topybackend.entities.responses.*;
import com.topybackend.services.AccountsHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class Signup {

    @Autowired
    private ProfileRepository profileRepo;
    @Autowired
    private SocialDataRepository socialRepo;

    @Autowired
    AccountsHelperService accountsHelper;

    @RequestMapping(value = "/userservice/signup/verify/")
    /*
        Verify valid username
     */
    public GenericBoolResponse verify(
            //Username
            @RequestParam(value = "name", required = true) String username
    ){
        return new GenericBoolResponse(accountsHelper.getUser(username)!=null);
    }

    /*
        Create account
     */
    @RequestMapping(value = "/userservice/signup/add/"/*, method = RequestMethod.POST*/)
    public Object signup(
            //Username
            @RequestParam(value = "name", required = true) String username,
            //Password
            @RequestParam(value = "pass", required = true) String password,
            //Social Data (linkedin)
            @RequestParam(value = "linkedInSocialData", required = true) String socialData
    ){
        AccountsResponse response = new AccountsResponse();
        response.setStatus(StatusCodes.OK);
        response.setUserName(username);
        response.setPassWord(password);

        ProfileResponse profile = new ProfileResponse();

        try{
            profile.setName(username);
            //profile.setId(response.getUserId());

            ProfileMinimalResponse minProfile = new ProfileMinimalResponse(profile);
            response.setMinimalProfile(minProfile);

            //save accounts data
            accountsHelper.saveUser(response);
        }
        catch(Exception m){
            //--log db write/validation exceptions
            response.setStatus(StatusCodes.UNKNOWN);
        }

        if(response.getUserId().isEmpty()){
            response.setStatus(StatusCodes.UNKNOWN);
        }
        else{
            //save linked in data
            try{

                Map<String, Object> linkedInData = new ObjectMapper().readValue(socialData, Map.class);

                //Populate generic socialprofile object with type linkedin
                UserSocialResponse socialLinkedInDataObject = new UserSocialResponse();
                socialLinkedInDataObject.setName(linkedInData.get("linkedInName").toString());
                socialLinkedInDataObject.setId(linkedInData.get("linkedInId").toString());
                socialLinkedInDataObject.setType(Types.ACCOUNTTYPE_LINKEDIN);
                socialLinkedInDataObject.setData((Map<String, Object>)linkedInData.get("data"));

                //social minprofile in profile object
                UserMinimalSocialResponse socialDataObject = new UserSocialResponse();
                socialDataObject.setId(socialLinkedInDataObject.getId());
                socialDataObject.setName(socialLinkedInDataObject.getName());
                socialDataObject.setType(Types.ACCOUNTTYPE_LINKEDIN);

                //save profile data
                //should we set profile.setName with social name object? --todo
                profile.setLinkedInData(socialDataObject);
                profile.setId(response.getUserId());
                profile.followingsCount = 0;
                profileRepo.save(profile);

                //save social data
                socialRepo.save(socialLinkedInDataObject);
            }
            catch (Exception e){
                e.printStackTrace();
                //--log json parse exceptions
            }
        }
        return response;
    }

}
