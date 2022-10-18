/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.validator;

import com.tdd.pojos.Account;
import com.tdd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AccountValidator implements Validator{

    @Autowired
    private AccountService accountService;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Account.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account p = (Account) target;
        if(p.getUsername().isEmpty()){
            errors.rejectValue("username",  "account.username.null");
        }
        if(p.getPassword().isEmpty()){
            errors.rejectValue("password", "account.password.null");
        }
        
        if(p.getName().isEmpty()){
            errors.rejectValue("name", "account.name.null");
        }
        
        if(p.getCmnd().isEmpty()){
            errors.rejectValue("cmnd", "account.cmnd.null");
        }
        
        if(p.getType() == Account.SHIPPER && p.getFile().isEmpty()){
            errors.rejectValue("file", "account.avt.null");
        }
        
        if(this.accountService.getAccounts(p.getUsername()) != null){
            errors.rejectValue("username", "account.username.isHas");
        }
    }
    
}
