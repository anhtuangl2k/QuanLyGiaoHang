/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdd.pojos.Account;
import com.tdd.pojos.Product;
import com.tdd.service.AccountService;
import com.tdd.service.ProductService;
import com.tdd.validator.ProductValidator;
import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private ProductService productService;  
    @Autowired
    private ProductValidator productValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(productValidator);
    }
    
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
    
    @GetMapping("/admin/product")
    public String productManager(Model model, @RequestParam(required = false) Map<String, String> params){
        model.addAttribute("product", new Product());
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getListProduct(params.get("kw"), page));
        model.addAttribute("counter", this.productService.countProduct());
        return "product";
    }
    
    @PostMapping("/admin/product")
    public String productManager(Model model, @ModelAttribute(value = "product")@Valid Product product, BindingResult result) throws IOException{
        if(!result.hasErrors()){
 
            
            if(this.productService.addOrUpdate(product))
                model.addAttribute("successMsg", "Thêm sản phẩm thành công");
            else
                model.addAttribute("errMsg", "Có lỗi xảy ra");
        }   
        return "product";
    }
}
