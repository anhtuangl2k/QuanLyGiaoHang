/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Auctions;
import com.tdd.pojos.OrderDetail;
import com.tdd.service.AuctionsService;
import com.tdd.service.OrderService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class AuctionsController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AuctionsService auctionsService;
    
    @GetMapping("/shipper/auctions")
    public String auctions(Model model){
        model.addAttribute("order", this.orderService.getOrderDetail());
        
        return "auctions";
    }
       
    @GetMapping("/auctions/{orderId}")
    public String orderDetail(Model model,
            @PathVariable(value = "orderId") int orderId) {
        
        model.addAttribute("order", this.orderService.getOrderById(orderId));
        
        return "auctionsdetail";
    }  
//    
//    @PostMapping("/auctions/{orderId}")
//    public String add(Model model, @ModelAttribute(value = "auctions") @Valid Auctions auctions,
//            BindingResult result){
//        
//        if (!result.hasErrors()) {
//            if (this.auctionsService.addOrUpdate(auctions) == true) {
//                return "redirect:/";
//            } else {
//                model.addAttribute("errMsg", "Something wrong!!!");
//            }
//        }
//       
//        return "auctionsdetail";
//    }

}
