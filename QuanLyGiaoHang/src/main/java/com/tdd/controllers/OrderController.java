/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.controllers;

import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import com.tdd.service.LoginService;
import com.tdd.validator.WebAppValidator;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tdd.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Admin
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/order")
    public String order(Model model, HttpSession session) {
        model.addAttribute("order", new OrderDetail());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

        return "order";
    }

    @PostMapping("/order")
    public String add(Model model, @ModelAttribute(value = "order") @Valid OrderDetail order,
            BindingResult result) {
        
        if (!result.hasErrors()) {
            if (this.orderService.addOrUpdate(order) == true) {
                return "redirect:/order/list";
            } else {
                model.addAttribute("errMsg", "Something wrong!!!");
            }
        }

        return "order";
    }

    @GetMapping("/order/list")
    public String orderList(Model model, HttpSession session) {
        Login l = (Login) session.getAttribute("currentUser");
        int id = l.getId();
        
        model.addAttribute("order", this.orderService.getOrderByUserId(id));

        return "orderlist";
    }

    @GetMapping("/order/{orderId}")
    public String orderDetail(Model model,
            @PathVariable(value = "orderId") int orderId) {
        model.addAttribute("order", this.orderService.getOrderById(orderId));

        return "orderdetail";
    }
}
