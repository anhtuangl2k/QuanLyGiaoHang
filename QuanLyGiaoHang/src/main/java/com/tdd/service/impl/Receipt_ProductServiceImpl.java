/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.Cart;
import com.tdd.pojos.Discount;
import com.tdd.pojos.Receipt;
import com.tdd.pojos.ReceiptProduct;
import com.tdd.repository.ProductRepository;
import com.tdd.repository.ReceiptResponsitory;
import com.tdd.repository.Receipt_ProductResponsitory;
import com.tdd.service.Receipt_ProductService;
import com.tdd.utils.Utils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receipt_ProductServiceImpl implements Receipt_ProductService{
    
    @Autowired
    private Receipt_ProductResponsitory receipt_ProductResponsitory;
    @Autowired
    private ReceiptResponsitory receiptResponsitory;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addReceipt_Product(ReceiptProduct r) {
        return this.receipt_ProductResponsitory.addReceipt_Product(r);
    }

    @Override
    public boolean addProductInCartForReceipt(Map<Integer, Cart> cart, Discount d) {
        try {
            if(Utils.ACCOUNT_LOGIN != null){
                Receipt r = new Receipt();
                r.setAmount(Utils.amount(cart));
                r.setGuestID(Utils.ACCOUNT_LOGIN);
                r.setStatus(Receipt.CHUA_GIAO);
                if(d != null){
                    r.setDiscountID(d);
                    Utils.DISCOUNT = null;
                }               
                LocalDate date = (LocalDate)java.time.LocalDate.now();
                r.setDateTime( Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                if(this.receiptResponsitory.addReceipt(r)){
                    for(Cart c : cart.values()){
                        ReceiptProduct rp= new ReceiptProduct();
                        rp.setPrice(c.getPrice());
                        rp.setQuantity(c.getQuantity());
                        rp.setProductID(this.productRepository.getProductByID(c.getProductId()));
                        rp.setReceiptID(r);
                        if(this.receipt_ProductResponsitory.addReceipt_Product(rp))
                            continue;
                        else
                            return false;
                    }
                }
                return true;
            }          
        } catch (Exception e) {
            System.out.println(e.getMessage() + "===ERROR ADD RECEIPT===");
        }
        return false;
    }
    
}
