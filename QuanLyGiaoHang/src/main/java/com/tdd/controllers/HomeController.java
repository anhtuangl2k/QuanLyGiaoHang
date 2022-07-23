/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Shipper;
import com.tdd.service.ShipperService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private ShipperService shipperService;
    
    @GetMapping("/")
    public String home(Model model){
        
        return "index";
    }
    
    @ModelAttribute
    public void common(Model model, HttpSession session){
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

    }
}
