/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.ReceiptProduct;
import com.tdd.repository.Receipt_ProductResponsitory;
import com.tdd.service.Receipt_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receipt_ProductServiceImpl implements Receipt_ProductService{
    
    @Autowired
    private Receipt_ProductResponsitory receipt_ProductResponsitory;

    @Override
    public boolean addReceipt_Product(ReceiptProduct r) {
        return this.receipt_ProductResponsitory.addReceipt_Product(r);
    }
    
}
