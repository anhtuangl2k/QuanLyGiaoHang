/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.tdd.pojos.Discount;
import com.tdd.repository.DiscountRepository;
import com.tdd.service.DiscountService;
import java.util.List;
import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService{

    @Autowired
    private DiscountRepository discountRepository;
    
    @Override
    public boolean addOrUpdate(Discount discount) {
        discount.setCode(randomAlphanumeric(8).toUpperCase());
        return this.discountRepository.addOrUpdate(discount); 
    }

    @Override
    public List<Discount> getListDiscount(String kw, int page) {
        return this.discountRepository.getListDiscount(kw, page);
    }

    @Override
    public long countDiscount() {
        return this.discountRepository.countDiscount();
    }

    @Override
    public Discount getDiscountByID(int ID) {
        return this.discountRepository.getDiscountByID(ID);
    }

    @Override
    public boolean deleteDiscount(int ID) {
        return this.discountRepository.deleteDiscount(ID);
    }

    @Override
    public Discount getDiscountByCode(String code) {
        return this.discountRepository.getDiscountByCode(code);
    }
    
}
