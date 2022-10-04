/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service;

import com.tdd.pojos.Cart;
import com.tdd.pojos.ReceiptProduct;
import java.util.Map;

public interface Receipt_ProductService {
    boolean addReceipt_Product(ReceiptProduct r) ;
    boolean addProductInCartForReceipt(Map<Integer, Cart> cart);
}
