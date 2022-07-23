/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.Shipper;
import com.tdd.repository.ShipperRepository;
import com.tdd.service.ShipperService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ShipperServiceImpl implements ShipperService{
    @Autowired
    private ShipperRepository shipperRepository;

    @Override
    public boolean addOrUpdate(Shipper shipper) {
        return this.shipperRepository.addOrUpdate(shipper);
    }

    @Override
    public List<Shipper> getShipperByLoginId(int id) {
        return this.shipperRepository.getShipperByLoginId(id);
    }

    @Override
    public Shipper getShipperById(int i) {
        return this.shipperRepository.getShipperById(i);
    }
    
}
