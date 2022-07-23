/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.Login;
import com.tdd.pojos.Rate;
import com.tdd.pojos.Shipper;
import com.tdd.repository.LoginRepository;
import com.tdd.repository.RateRepository;
import com.tdd.repository.ShipperRepository;
import com.tdd.service.RateService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RateServiceImpl implements RateService{
    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private ShipperRepository shipperRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Rate addRate(String comment, int rating, int shipperId, Login login) {
//        Login s = this.loginRepository.getLoginById(shipperId);
        Shipper s = this.shipperRepository.getShipperById(shipperId);

        Rate rate = new Rate();
        rate.setComment(comment);
        rate.setRating(rating);
        rate.setShipperId(s);
        rate.setLoginId(login);
        rate.setCreatedDate(new Date());
        
        return this.rateRepository.addRate(rate);
    }

    @Override
    public List<Rate> getRateByShipperId(int i) {
        return this.rateRepository.getRateByShipperId(i);
    }
    
}
