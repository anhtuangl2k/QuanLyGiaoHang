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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
            receipt.setStatus(Receipt.CHUA_GIAO);
            return this.receiptResponsitory.addReceipt(receipt);
        }     
        return false;
    }

    @Override
    public List<Receipt> listReceiptOfGuest(Integer id, Integer status) {
        return this.receiptResponsitory.listReceiptOfGuest(id, status);
    }

    @Override
    public Receipt getReceiptById(Integer id) {
        return this.receiptResponsitory.getReceiptById(id);
    }

    @Override
    public boolean changeStatusReceipt(Integer id, Account a) {
        Receipt r = this.receiptResponsitory.getReceiptById(id);
        if(r != null){
            System.out.println("oke");
            if(r.getStatus() == Receipt.CHUA_GIAO)
                r.setStatus(Receipt.DANG_GIAO);
            else if(r.getStatus() == Receipt.DANG_GIAO)
                r.setStatus(Receipt.DA_GIAO);
            if(r.getShipperID() == null)
                r.setShipperID(a);
            return this.receiptResponsitory.updateReceipt(r);
        }
        return false;
    }

    @Override
    public List<Object[]> receiptStats(String kw, Date fromDate, Date toDate) {
        return this.receiptResponsitory.receiptStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> receiptMonthStats(String kw, Date formDate, Date toDate) {
        return this.receiptResponsitory.receiptMonthStats(kw, formDate, toDate);
    }
    
}
