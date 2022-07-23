/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.repository;

import com.tdd.pojos.ShipperAuctions;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ShipperAuctionsRepository {
    List<ShipperAuctions> getShipperAuctionsByLoginId(int id);
}
