/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.Account;
import com.tdd.repository.AccountResponsitory;
import com.tdd.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountResponsitory accountResponsitory;

    @Override
    public boolean addAccount(Account account) {
        try {
            if(account.getType() == Account.GUEST){
                account.setStatus(Account.ENABLE);
            }
            if(account.getType() == Account.SHIPPER){
                account.setStatus(Account.DISABLE);
            }
            return this.accountResponsitory.addAccount(account);
        } catch (Exception e) {
            e.getMessage(); 
        }
        return false;
    }

    @Override
    public List<Account> getListAccountShipper() {
        return this.accountResponsitory.getListAccountShipper();
    }

    @Override
    public Account getAccountByID(int id) {
        return this.accountResponsitory.getAccountByID(id);
    }

    @Override
    public boolean changeStatus(int id) {
        return this.accountResponsitory.changeStatus(id);
    }
    
    
}
