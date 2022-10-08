/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service;

import com.tdd.pojos.Account;
import com.tdd.pojos.Receipt;
import java.util.Date;
import java.util.List;

public interface ReceiptService {
    boolean addReceipt(Receipt receipt, String username);
    List<Receipt> listReceiptOfGuest(Integer id, Integer status);
    Receipt getReceiptById(Integer id);
    boolean changeStatusReceipt(Integer id, Account a);
    List<Object[]> receiptStats(String kw, Date fromDate, Date toDate);
}
