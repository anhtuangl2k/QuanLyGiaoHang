/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Discount;
import com.tdd.service.DiscountService;
import com.tdd.validator.DiscountValidator;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiscountController {
    
    @Autowired
    private DiscountService discountService;
    
    @Autowired
    private DiscountValidator discountValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(discountValidator);
    }
    
    @GetMapping("/admin/discount")
    public String KhuyenMai(Model model, @RequestParam(required = false) Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("discount", new Discount());
        model.addAttribute("discounts", this.discountService.getListDiscount("", page));
        model.addAttribute("counter", this.discountService.countDiscount());
        return "discount";
    }
    
    @PostMapping("/admin/discount")
    public String  KhuyenMai(Model model,@ModelAttribute(value = "discount")@Valid Discount discount,
            BindingResult result){
        if(!result.hasErrors()){
            if(this.discountService.addOrUpdate(discount))
                model.addAttribute("successMsg", "Thêm thành công");
            else
                model.addAttribute("errMsg", "Something Wrong!!!");
        }
        return "discount";
    }
    
}
