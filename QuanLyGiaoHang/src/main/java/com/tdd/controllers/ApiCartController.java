/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.cloudinary.Util;
import com.tdd.pojos.Cart;
import com.tdd.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCartController {
    
    @PostMapping("api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){        
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart == null)
            cart = new HashMap<>();
        int productId = params.getProductId();
        if(cart.containsKey(productId) == true){ // sản phẩm đã có trong giỏ
            Cart c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        }else{ // sản phẩm chưa có trong giỏ
            System.out.println(params.getImage());
            cart.put(productId, params);
        }       
        session.setAttribute("cart", cart);       
        return Utils.countCart(cart);
    }
    
    @PutMapping("/api/cart")
    public ResponseEntity<Map<String, String>> updateToCart(@RequestBody Cart params, HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart == null)
            cart = new HashMap<>();
        int productId = params.getProductId();
        if(cart.containsKey(productId) == true){ // sản phẩm đã có trong giỏ
            Cart c = cart.get(productId);
            c.setQuantity(params.getQuantity());
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(Utils.cartStats(cart, null), HttpStatus.OK);   
    }
    
    @DeleteMapping("/api/cart/{productId}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "productId") int productId, HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null && cart.containsKey(productId)){
            cart.remove(productId);
            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(Utils.cartStats(cart, null), HttpStatus.OK);   
    }
}
