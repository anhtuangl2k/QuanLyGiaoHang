/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.utils;

import com.tdd.pojos.Cart;
import java.util.HashMap;
import java.util.Map;


public class Utils {
    
    // Hàm đếm số lượng sản phẩm trong giỏ hàng
    public static int countCart(Map<Integer, Cart> cart){
        int q = 0;
        if(cart != null)
            for (Cart c: cart.values())
                q += c.getQuantity();       
        return q;
    }
    
    //Hàm tính tồng tiền trong giỏ hàng
    public static Map<String, String> cartStats(Map<Integer, Cart> cart){
        double s = 0;
        int q = 0;
        if(cart != null)
            for(Cart c : cart.values()){
                q+= c.getQuantity();
                s+= c.getQuantity() * c.getPrice();
            }
        Map<String, String> kq  = new HashMap<>();
        kq.put("counter",String.valueOf(q));
        kq.put("amount", String.valueOf(s));
        return kq;
    }
}
