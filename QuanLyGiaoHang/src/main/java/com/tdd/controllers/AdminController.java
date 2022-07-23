/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import com.tdd.service.LoginService;
import com.tdd.service.OrderService;
import com.tdd.service.OrderStatusService;
import com.tdd.service.ShipperService;
import com.tdd.service.StatsService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class AdminController {
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ShipperService shipperService;
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    
    @GetMapping("/admin/shipper-list")
    public String listShipper(Model model){
        model.addAttribute("shipper", this.statsService.statsShipper());
        
        return "shipper-list";
    }
    
    @GetMapping("/admin/shipper/{shipperId}")
    public String shipperDetail(Model model,
        @PathVariable(value = "shipperId") int shipperId) {
        model.addAttribute("s", this.shipperService.getShipperById(shipperId));
        
        return "shipper-info";
    }
    
    @GetMapping("/admin/shipper-browse")
    public String shipperBrowse(Model model,
            @RequestParam(required = false) Map<String, String> params){
//        int id = Integer.parseInt(params.get("id"));
        model.addAttribute("shipper", this.statsService.statsShipper());
//        this.loginService.setUserRole(id);
        
        return "shipper-browse";
    }
    
//    @PostMapping("/admin/shipper-browse")
//    public String addShipperBrowse(Model model,
//            @ModelAttribute(value = "login") int id){
//        
//        if(this.loginService.setUserRole(id) != null)
//            return "redirect:/admin";
//        
//        return "shipper-browse";
//    }
    
    @GetMapping("/admin/shipper-setting")
    public String shipperSetting(Model model){
        model.addAttribute("shipper", this.statsService.statsShipper());
        
        return "shipper-setting";
    }
    
    @GetMapping("/admin/statistique")
    public String statistique(Model model){
        model.addAttribute("stats1", this.orderStatusService.getOrderStatusById(1));
        model.addAttribute("stats2", this.orderStatusService.getOrderStatusById(2));
        return "statistique";
    }
    
    @GetMapping("/admin/order-search")
    public String orderSearch(Model model,
            @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", "");
        model.addAttribute("stats", this.statsService.searchOrder2(kw));
        
        return "order-search";
    }
    
    @GetMapping("/admin/order-search/{orderId}")
    public String orderDetail(Model model,
        @PathVariable(value = "orderId") int orderId) {
        model.addAttribute("order", this.orderService.getOrderById(orderId));
        
        return "order-search2";
    }
    
    @GetMapping("/admin/chart")
    public String chars(Model model){
        model.addAttribute("chart", this.statsService.statsRevenue());
        
        return "chart";
    }
    
    @GetMapping("/admin/chart2")
    public String chars2(Model model){
        model.addAttribute("chart", this.statsService.statsRevenue());
        
        return "chart2";
    }
}
