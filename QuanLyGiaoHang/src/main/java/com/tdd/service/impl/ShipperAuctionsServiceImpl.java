/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.ShipperAuctions;
import com.tdd.repository.ShipperAuctionsRepository;
import com.tdd.service.ShipperAuctionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ShipperAuctionsServiceImpl implements ShipperAuctionsService{
    @Autowired
    private ShipperAuctionsRepository shipperAuctionsRepository;

    @Override
    public List<ShipperAuctions> getShipperAuctionsByLoginId(int id) {
        return this.shipperAuctionsRepository.getShipperAuctionsByLoginId(id);
    }
    
}
