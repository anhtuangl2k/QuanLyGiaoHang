/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.service;

import com.tdd.pojos.Shipper;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ShipperService {
    boolean addOrUpdate(Shipper shipper); 
    List<Shipper> getShipperByLoginId(int id);
    Shipper getShipperById(int shipperId);
}
