/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Cart;
import com.tdd.pojos.Discount;
import com.tdd.service.AccountService;
import com.tdd.service.DiscountService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    
    @Autowired
    private Receipt_ProductService receipt_ProductService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private DiscountService discountService;
    
    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session){
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    }
    
    
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session, @RequestParam(required = false) Map<String, String> params){
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null)
            model.addAttribute("carts", cart.values());
        else
            model.addAttribute("carts", null);
        
        String code = params.getOrDefault("discount", "");
        if(code != ""){
            Discount d = this.discountService.getDiscountByCode(code);
            if(d != null){
                model.addAttribute("cartStats", Utils.cartStats(cart, d));
                model.addAttribute("msg", "Thêm mã giảm " + d.getMoneyReduce().toString() + "thành công" );
                Utils.DISCOUNT = d;
            }else{
                model.addAttribute("cartStats", Utils.cartStats(cart, null));
                model.addAttribute("msg", "Mã ko hợp lệ" );
            }
        }else{
            model.addAttribute("cartStats", Utils.cartStats(cart, null));
        }     
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
        if(this.receipt_ProductService.addProductInCartForReceipt(cart, Utils.DISCOUNT)){
            model.addAttribute("msg", "Thanh toán thành công");
        }else
        {
            model.addAttribute("msg", "Có lỗi xảy ra trong quá trình thanh toán");
        }
        return "cart";
    }
}
