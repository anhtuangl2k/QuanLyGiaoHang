/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controllers;

import com.cloudinary.Util;
import com.tdd.pojos.Receipt;
import com.tdd.service.ReceiptService;
import com.tdd.utils.Utils;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiReceiveController {
    
    @Autowired
    private ReceiptService receiptService;
    
    @GetMapping(path = "/changeStatusReceipt/{ID}")
     public ResponseEntity<Receipt> changeStatusReceipt(@PathVariable("ID") Integer ID){
        try {
            if(this.receiptService.changeStatusReceipt(ID, Utils.ACCOUNT_LOGIN))
                return new ResponseEntity<>( HttpStatus.OK);       
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK); 
    }
    
}
