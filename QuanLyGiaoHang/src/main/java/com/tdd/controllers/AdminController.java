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
import com.tdd.service.ReceiptService;
import com.tdd.validator.ProductValidator;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private  ReceiptService receiptService;
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
        
        model.addAttribute("counter", this.productService.countProduct());

        
        Integer id = null;
        if(params.get("id") != null){
            id = Integer.parseInt(params.get("id"));
            Product p = this.productService.getProductByID(id);
            p.setName(params.get("name"));
            p.setPrice(Double.parseDouble(params.get("price")));
            p.setAmount(Integer.parseInt(params.get("amount")));
            if(this.productService.addOrUpdate(p)){
                model.addAttribute("successMsg", "Cập nhật sản phẩm thành công");
            }else
            {
                 model.addAttribute("errMsg", "Có lỗi xảy ra");
            }
        }
        model.addAttribute("products", this.productService.getListProduct(params.getOrDefault("kw", ""), page));
        
        return "product";
    }
    
    @PostMapping("/admin/product")
    public String productManager(Model model, @ModelAttribute(value = "product")@Valid Product product, BindingResult result,
            @RequestParam(required = false) Map<String, String> params) throws IOException{
        if(!result.hasErrors()){           
            if(this.productService.addOrUpdate(product)){
              
                model.addAttribute("successMsg", "Thêm sản phẩm thành công");
            }               
            else
                model.addAttribute("errMsg", "Có lỗi xảy ra");
        }   
        return "product";
    }
    
    @GetMapping("/admin/deleteProduct")
    public String detail(Model model, @RequestParam(required = false) Map<String, String> params){
        Integer id = Integer.parseInt( params.get("id"));
        Product p = this.productService.getProductByID(id);
        if(p.getReceiptProductCollection().size() > 0){
            model.addAttribute("errMsg", "Sản phẩm đang được dử dụng, ko thể xóa");
        }else{
            if(this.productService.deleteProduct(id)){
                model.addAttribute("successMsg", "Xóa thành công");
            }else{
                model.addAttribute("errMsg", "Cõ lỗi xảy ra");
            }
        }
        return "redirect:/admin/product";
    }
            
    
    @GetMapping("/admin/statistic")
    public String statistic(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        String kw = params.getOrDefault("kw", null);

        Date fromDate = null;
        String from = params.getOrDefault("fromDate", null);
        if(from!=null && from != "")
          fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);  
        
        Date toDate = null;
        String to = params.getOrDefault("toDate", null);
        if(to!=null && to != "")
            toDate = new SimpleDateFormat("yyyy-MM-dd").parse(to);;
  
        model.addAttribute("productStats", this.receiptService.receiptStats(kw, fromDate, toDate));      
        return "statistic";
    }
    
    @GetMapping("/admin/month-stats")
    public String monthStats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        
        Date fromDate = null;
        String from = params.getOrDefault("fromDate", null);
        if(from!=null && from != "")
          fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);  
        
        Date toDate = null;
        String to = params.getOrDefault("toDate", null);
        if(to!=null && to != "")
            toDate = new SimpleDateFormat("yyyy-MM-dd").parse(to);;
             
        model.addAttribute("productMonthStats", this.receiptService.receiptMonthStats(null, fromDate, toDate));    
        return "month-stats";
    }
    
    @GetMapping("/admin/shipper")
    public String shipper(Model model){
        model.addAttribute("shipper", this.accountService.listShipper());
        return "shipper";
    }
    
    @GetMapping("/admin/guest")
    public String guest(Model model){
        model.addAttribute("guest", this.accountService.listGuest());
        return "guest";
    }
}
