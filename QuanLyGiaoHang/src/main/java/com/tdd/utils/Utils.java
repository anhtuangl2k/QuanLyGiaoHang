/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.utils;

import com.tdd.pojos.Account;
import com.tdd.pojos.Cart;
import com.tdd.pojos.Discount;
import java.util.HashMap;
import java.util.Map;


public class Utils {
    
    public static Account ACCOUNT_LOGIN;
    public static Discount DISCOUNT;
    
    
    // Hàm đếm số lượng sản phẩm trong giỏ hàng
    public static int countCart(Map<Integer, Cart> cart){
        int q = 0;
        if(cart != null)
            for (Cart c: cart.values())
                q += c.getQuantity();       
        return q;
    }
    
    //Hàm tính tồng tiền trong giỏ hàng
    public static Map<String, String> cartStats(Map<Integer, Cart> cart, Discount discount){
        double s = 0;
        int q = 0;
        if(cart != null){
            for(Cart c : cart.values()){
                q+= c.getQuantity();
                s+= c.getQuantity() * c.getPrice();
            }
            if(discount != null)
                s = s - discount.getMoneyReduce();
        }

        Map<String, String> kq  = new HashMap<>();
        kq.put("counter",String.valueOf(q));
        kq.put("amount", String.valueOf(s));
        if(discount != null)
            kq.put("id", String.valueOf(discount.getId()));
        return kq;
    }
        
    
    public static Double amount(Map<Integer, Cart> cart){
        double s = 0;
        if(cart != null)
            for(Cart c : cart.values()){
                s+= c.getQuantity() * c.getPrice();
            }
        return s;
    }

}
