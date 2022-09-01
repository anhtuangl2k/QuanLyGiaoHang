/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Account;
import com.tdd.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AdminController {
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    
    @GetMapping("/admin/browsing-shipper")
    public String browsingShipper(Model model){
        List<Account> list = this.accountService.getListAccountShipper();
        model.addAttribute("accountShipper", list);
        return "browsing-shipper";
    }
    
    @GetMapping("/admin/changeStatus/{ID}")
    public String changeStatus(Model model, @PathVariable("ID") Integer ID){
        if(this.accountService.changeStatus(ID)){
            model.addAttribute("successMsg", "Duyệt thành công");
        }       
        return "browsing-shipper";
    }
}
