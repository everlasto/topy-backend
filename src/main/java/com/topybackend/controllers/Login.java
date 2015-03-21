package com.topybackend.controllers;

import com.topybackend.constants.StatusCodes;
import com.topybackend.datastores.AccountsRepository;
import com.topybackend.entities.responses.AccountsResponse;
import com.topybackend.services.AccountsHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by prashanth.a on 18/03/15.
 */
@RestController
public class Login {

    @Autowired
    private AccountsHelperService accountsHelper;

    /*
        Login authentication
    */
    @RequestMapping(value = "/userservice/signin" /*, method = RequestMethod.POST*/)
    public AccountsResponse login(
            //Username
            @RequestParam(value = "name", required = true) String username,
            //Password
            @RequestParam(value = "pass", required = true) String password
    ){
        AccountsResponse account = accountsHelper.getUser(username);
        if(account!=null && !account.getUserId().isEmpty()){
            if( !password.equals(account.getPassWord(true)) ) {
                account.setUserId(null);
                account.setStatus(StatusCodes.FAIL);
            }
            return account;
        }
        else{
            account = new AccountsResponse();
            account.setStatus(StatusCodes.NO_ACCT);
            return account;
        }
    }
}

