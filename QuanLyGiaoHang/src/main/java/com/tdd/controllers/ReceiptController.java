/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Receipt;
import com.tdd.service.ReceiptService;
import com.tdd.utils.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReceiptController {
    
    @Autowired
    private ReceiptService receiptService;
    
    
    @GetMapping("/order")
    public String order(Model model){
        System.out.println(Utils.ACCOUNT_LOGIN);
        if(Utils.ACCOUNT_LOGIN != null)
        {
            model.addAttribute("receipts", this.receiptService.listReceiptOfGuest(Utils.ACCOUNT_LOGIN.getId()));
            
        }
        
        return "order";
    }
}
