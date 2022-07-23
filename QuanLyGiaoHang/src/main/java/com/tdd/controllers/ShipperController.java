/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Login;
import com.tdd.pojos.Shipper;
import com.tdd.repository.RateRepository;
import com.tdd.service.LoginService;
import com.tdd.service.RateService;
import com.tdd.service.ShipperAuctionsService;
import com.tdd.service.ShipperService;
import javax.servlet.http.HttpSession;
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
public class ShipperController {
    @Autowired
    private ShipperAuctionsService shipperAuctionsService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RateService rateService;
    
    @GetMapping("/shipper/received")
    public String received(Model model, HttpSession session){
        Login l = (Login) session.getAttribute("currentUser");
        int id = l.getId();
        model.addAttribute("received" , this.shipperAuctionsService.getShipperAuctionsByLoginId(id));
        
        return "received";
    }

    @GetMapping("/register/shipper")
    public String shipper(Model model, HttpSession session) {
        model.addAttribute("shipper", new Shipper());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

        return "registershipper";
    }

    @PostMapping("/register/shipper")
    public String add(Model model, @ModelAttribute(value = "shipper") @Valid Shipper shipper,
            BindingResult result, HttpSession session) {
        if (!result.hasErrors()) {
            if (this.shipperService.addOrUpdate(shipper) == true) {
                return "redirect:/";
            } else {
                model.addAttribute("errMsg", "Đã có lỗi xảy ra!");
            }
        }

        return "registershipper";
    }
    
    @GetMapping("/{shipperId}")
    public String shipperInfo(Model model,
            @PathVariable(value = "shipperId") int shipperId) {
        int id = shipperId;
        model.addAttribute("shipper", this.shipperService.getShipperById(shipperId));

        return "shipper-info2";
    }
}
