/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.Auctions;
import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import com.tdd.pojos.Shipper;
import com.tdd.repository.AuctionsRepository;
import com.tdd.repository.LoginRepository;
import com.tdd.repository.OrderRepository;
import com.tdd.repository.ShipperRepository;
import com.tdd.service.AuctionsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class AuctionsServiceImpl implements AuctionsService{
    @Autowired
    private AuctionsRepository auctionsRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private ShipperRepository shipperRepository;

    @Override
    public boolean addOrUpdate(Auctions auctions) {
        return this.auctionsRepository.addOrUpdate(auctions);
    }

    @Override
    public Auctions addAuctions(String content, long price, int orderId, int id, Login loginId) {
        OrderDetail o = this.orderRepository.getOrderById(orderId);

//        List<Shipper> shippers = (List<Shipper>) (Shipper) this.shipperRepository.getShipperByLoginId(id);
//        Shipper shipper = shippers.get(0);
//        int shipperId = shipper.getId();
        Shipper shipper = this.shipperRepository.getShipperById(4);
        
        Auctions au = new Auctions();
        au.setContent(content);
        au.setPrice(price);
        au.setOrderId(o);
        au.setShipperId(shipper);
        au.setLoginId(loginId);
        au.setCreatedDate(new Date());
        
        return this.auctionsRepository.addAuctions(au);
    }
    
}
