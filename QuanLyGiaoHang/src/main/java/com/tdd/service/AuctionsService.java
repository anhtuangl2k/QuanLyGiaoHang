/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.service;

import com.tdd.pojos.Auctions;
import com.tdd.pojos.Login;

/**
 *
 * @author Admin
 */
public interface AuctionsService {
    boolean addOrUpdate(Auctions auctions);
    Auctions addAuctions(String content, long price, int orderId, int id, Login loginId);
}
