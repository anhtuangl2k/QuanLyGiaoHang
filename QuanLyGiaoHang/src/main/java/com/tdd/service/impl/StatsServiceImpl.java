/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.OrderDetail;
import com.tdd.repository.StatsRepository;
import com.tdd.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> statsShipper() {
        return this.statsRepository.statsShipper();
    }

    @Override
    public List<Object[]> starsOrder() {
        return this.statsRepository.starsOrder();
    }

    @Override
    public List<Object[]> searchOrder(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.searchOrder(kw, fromDate, toDate);
    }

    @Override
    public List<OrderDetail> searchOrder2(String kw) {
        return this.statsRepository.searchOrder2(kw);
    }

    @Override
    public List<Object[]> statsRevenue() {
        return this.statsRepository.statsRevenue();
    }
    
}
