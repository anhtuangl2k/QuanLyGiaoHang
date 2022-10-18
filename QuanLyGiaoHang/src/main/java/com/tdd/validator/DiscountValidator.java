/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.validator;

import com.tdd.pojos.Discount;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DiscountValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Discount.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Discount d = (Discount) target;
        
        if(d.getContent().isEmpty()){
            errors.rejectValue("content",  "discount.contents.null");
        }
        
        if(d.getMoneyReduce() == null){
            errors.rejectValue("moneyReduce",  "discount.moneyReduce.null");
        }
    }
    
}
