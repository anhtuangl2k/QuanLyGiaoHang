/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Receipt;
import com.tdd.service.AccountService;
import com.tdd.service.ReceiptService;
import com.tdd.utils.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReceiptController {
    
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private AccountService accountService;
    
    
    @GetMapping("/order")
    public String order(Model model){
        if(Utils.ACCOUNT_LOGIN == null)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
            Utils.ACCOUNT_LOGIN = this.accountService.getAccounts(authentication.getName()).get(0);            
        }
        model.addAttribute("receipts", this.receiptService.listReceiptOfGuest(Utils.ACCOUNT_LOGIN.getId(), null));
        return "order";
    }
    
    @GetMapping("/receive")
    public String receive(Model model){
        if(Utils.ACCOUNT_LOGIN == null)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
            Utils.ACCOUNT_LOGIN = this.accountService.getAccounts(authentication.getName()).get(0);
        }  
        List<Receipt> list = this.receiptService.listReceiptOfGuest(Utils.ACCOUNT_LOGIN.getId(), Receipt.DANG_GIAO);
        list.addAll(this.receiptService.listReceiptOfGuest(null, Receipt.CHUA_GIAO));
        list.addAll(this.receiptService.listReceiptOfGuest(Utils.ACCOUNT_LOGIN.getId(), Receipt.DA_GIAO));
        model.addAttribute("receipts", list);    
        return "receive";
    }
    
    @GetMapping("/receive/{ID}")
    public String detail(Model model, @PathVariable(value="ID") int ID){
        model.addAttribute("receipt", this.receiptService.getReceiptById(ID));
        System.out.println(this.receiptService.getReceiptById(ID).getCommentCollection());
        return "receive-details";
    }
    
}
