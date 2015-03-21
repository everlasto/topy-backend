package com.topybackend.services;

import com.topybackend.datastores.AccountsRepository;
import com.topybackend.entities.responses.AccountsResponse;
import com.topybackend.entities.responses.GenericBoolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by prashanth.a on 20/03/15.
 */
@Service
public class AccountsHelperService {
    @Autowired
    AccountsRepository accountsRepo;

    public AccountsHelperService() {
    }

    public AccountsResponse getUser(String username){
        AccountsResponse account = accountsRepo.findByUserName(username);
        if(account!=null && !account.getUserId().isEmpty()){
            return account;
        }
        return null;
    }

    public AccountsResponse getUserById(String userId){
        AccountsResponse account = accountsRepo.findByUserId(userId);
        if(account!=null && !account.getUserId().isEmpty()){
            account.getMinimalProfile().setId(userId);
            return account;
        }
        return null;
    }

    public void saveUser(AccountsResponse account){
        accountsRepo.save(account);
    }

}
