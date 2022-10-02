/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.Account;
import com.tdd.repository.AccountResponsitory;
import com.tdd.service.AccountService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountResponsitory accountResponsitory;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addAccount(Account account) {
        try {
            if(account.getType() == Account.GUEST){
                account.setStatus(Account.ENABLE);
            }
            if(account.getType() == Account.SHIPPER){
                account.setStatus(Account.DISABLE);
            }
            String pass = account.getPassword();
            account.setPassword(this.passwordEncoder.encode(pass));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Account> accounts = this.accountResponsitory.getAccounts(username);
        if(accounts.isEmpty())
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        Account a = accounts.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(a.getType().toString()));
        return new org.springframework.security.core.userdetails.User(a.getUsername(), a.getPassword(), auth);
    }
    
    
}
