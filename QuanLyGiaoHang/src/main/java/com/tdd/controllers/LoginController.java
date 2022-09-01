/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.cloudinary.utils.ObjectUtils;
import com.tdd.pojos.Account;
import com.tdd.service.AccountService;
import com.tdd.validator.AccountValidator;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
        
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountValidator accountValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(accountValidator);
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("account", new Account());
        return "signup";
    }
    
    @PostMapping("/signup")
    public String signup(Model model,@ModelAttribute(value = "account")@Valid Account account, BindingResult result){
        if(!result.hasErrors()){
            if(this.accountService.addAccount(account))
                model.addAttribute("successMsg", "Đăng kí thành công");
            else
                model.addAttribute("errMsg", "Có lỗi xảy ra");
        }           
        return "signup";
    }
}
