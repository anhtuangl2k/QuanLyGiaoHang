/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.repository;

import com.tdd.pojos.Auctions;

/**
 *
 * @author Admin
 */
public interface AuctionsRepository {
    boolean addOrUpdate(Auctions auctions);
    Auctions addAuctions(Auctions au);
}
