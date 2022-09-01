/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.tdd.pojos.Account;
import com.tdd.pojos.Discount;
import com.tdd.service.AccountService;
import com.tdd.service.DiscountService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @Autowired
    private DiscountService discountService;
    @Autowired 
    private AccountService accountService;
    
    @DeleteMapping("/api/deleteDiscount/{ID}")
    public ResponseEntity<Discount> deleteDiscount(@PathVariable("ID") Integer ID) {
        if(this.discountService.deleteDiscount(ID)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);    
    }
    
    @GetMapping("/api/discounts")
    public ResponseEntity<List<Discount>> listDiscounts() {
        List<Discount> discounts = this.discountService.getListDiscount("", 1);

        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }
    
    @GetMapping("/api/shipper")
    public ResponseEntity<List<Account>> listShipper() {
        List<Account> discounts = this.accountService.getListAccountShipper();

        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }
    
    @GetMapping(path = "/api/getDiscount/{ID}" , produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Discount> getDiscount(@PathVariable("ID") Integer ID){
        try {
            Discount d = this.discountService.getDiscountByID(ID);
            return new ResponseEntity<>(d, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping(path = "/api/updateDiscount/{ID}", produces = {
        MediaType.APPLICATION_JSON_VALUE})
     public ResponseEntity<Discount> updateDiscount(@PathVariable("ID") Integer ID,
            @Valid @RequestBody Discount discount){
        try {
                if(this.discountService.addOrUpdate(discount)){
            return new ResponseEntity<>(this.discountService.getDiscountByID(discount.getId()), HttpStatus.OK);
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
}   
