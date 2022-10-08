/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Cart;
import com.tdd.service.AccountService;
import com.tdd.service.Receipt_ProductService;
import com.tdd.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CartController {
    
    @Autowired
    private Receipt_ProductService receipt_ProductService;
    @Autowired
    private AccountService accountService;
    
    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session){
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }
    
    
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null)
            model.addAttribute("carts", cart.values());
        else
            model.addAttribute("carts", null);
        
        model.addAttribute("cartStats", Utils.cartStats(cart));
        return "cart";
    }
    
    @GetMapping("/payment")
    public String payment(Model model, HttpSession session){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(Utils.ACCOUNT_LOGIN == null)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
            Utils.ACCOUNT_LOGIN = this.accountService.getAccounts(authentication.getName()).get(0);
        }  
        if(this.receipt_ProductService.addProductInCartForReceipt(cart)){
            model.addAttribute("msg", "Thanh toán thành công");
        }else
        {
            model.addAttribute("msg", "Có lỗi xảy ra trong quá trình thanh toán");
        }
        return "cart";
    }
}
