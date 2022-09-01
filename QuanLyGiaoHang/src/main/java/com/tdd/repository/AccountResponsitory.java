/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository;

import com.tdd.pojos.Account;
import java.util.List;


public interface AccountResponsitory {
    boolean addAccount(Account account);
    List<Account> getListAccountShipper();
    Account getAccountByID(int id);
    boolean changeStatus(int id);
}
