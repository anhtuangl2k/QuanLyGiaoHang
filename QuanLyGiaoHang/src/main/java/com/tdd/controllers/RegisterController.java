/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Login;
import com.tdd.service.LoginService;
import com.tdd.service.impl.LoginServiceImpl;
import com.tdd.validator.WebAppValidator;
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

/**
 *
 * @author Admin
 */
@Controller
public class RegisterController {

    @Autowired
    private LoginService userDetailsService;
    @Autowired
    private WebAppValidator loginValidator;
    @Autowired
    private LoginServiceImpl loginServiceImpl;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(loginValidator);
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new Login());
        return "register";
    }

    @PostMapping("/register")
    public String add(Model model, @ModelAttribute(value = "register") @Valid Login login,
            BindingResult result) {

//        if (result.hasErrors()) {
//        } else {
            if (this.userDetailsService.addLogin(login) == true) {
                return "redirect:/login";
            }else{
                if (!loginServiceImpl.getLoginByUsername(login.getUsername()).isEmpty()) {
                    model.addAttribute("errUser", "Tên tài khoản đã tồn tại");
                }
                if (!loginServiceImpl.getLoginByPhone(login.getPhone()).isEmpty()) {
                    model.addAttribute("errPhone", "Số điện thoại đã được sử dụng");
                }
                if (!loginServiceImpl.getLoginByEmail(login.getEmail()).isEmpty()) {
                    model.addAttribute("errEmail", "Địa chỉ email đã được sử dụng");
                }
            }
//        }

        return "register";
    }
}
