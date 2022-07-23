/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.service;

import com.tdd.pojos.ShipperAuctions;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ShipperAuctionsService {
    List<ShipperAuctions> getShipperAuctionsByLoginId(int id);
}
