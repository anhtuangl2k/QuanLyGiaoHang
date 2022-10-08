/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service;

import com.tdd.pojos.Account;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface AccountService extends UserDetailsService{
     public boolean addAccount(Account account);
      List<Account> getListAccountShipper();
      Account getAccountByID(int id);
      boolean changeStatus(int id);
      List<Account> getAccounts(String username);
}
