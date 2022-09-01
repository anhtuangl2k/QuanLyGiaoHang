/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.validator;

import com.tdd.pojos.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product p = (Product) target;
        if(p.getName().isEmpty()){
            errors.rejectValue("name",  "product.name.null");
        }
        
        if(p.getPrice() == null){
            errors.rejectValue("price",  "product.price.null");
        }
        
        if(p.getAmount() == null){
            errors.rejectValue("amount",  "product.amount.null");
        }
        
        if(p.getFile().isEmpty()){
            errors.rejectValue("file",  "product.file.null");
        }
    }
    
}
