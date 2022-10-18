/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository;

import com.tdd.pojos.Receipt;
import java.util.Date;
import java.util.List;

public interface ReceiptResponsitory {
    boolean addReceipt(Receipt receipt);
    List<Receipt> listReceiptOfGuest(Integer id, Integer status);
    Receipt getReceiptById(Integer id);
    boolean updateReceipt(Receipt r);
    List<Object[]> receiptStats(String kw, Date fromDate, Date toDate);
    List<Object[]> receiptMonthStats(String kw, Date fromDate, Date toDate);
}
