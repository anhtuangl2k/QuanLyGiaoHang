/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.Account;
import com.tdd.pojos.Receipt;
import com.tdd.repository.AccountResponsitory;
import com.tdd.repository.ReceiptResponsitory;
import com.tdd.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReceiptServiceImpl implements ReceiptService{
    
    @Autowired
    private ReceiptResponsitory receiptResponsitory;
    @Autowired
    private AccountResponsitory accountResponsitory;

    @Override
    public boolean addReceipt(Receipt receipt, String username) {
        
        if(!username.isEmpty() && username != ""){
            Account a = this.accountResponsitory.getAccounts(username).get(0);
            receipt.setGuestID(a);
            return this.receiptResponsitory.addReceipt(receipt);
        }     
        return false;
    }
    
}
