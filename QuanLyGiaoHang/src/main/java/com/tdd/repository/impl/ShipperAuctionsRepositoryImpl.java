/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Login;
import com.tdd.pojos.ShipperAuctions;
import com.tdd.repository.ShipperAuctionsRepository;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class ShipperAuctionsRepositoryImpl implements ShipperAuctionsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<ShipperAuctions> getShipperAuctionsByLoginId(int id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Login login = session.get(Login.class, id);
        List<ShipperAuctions> list = (List<ShipperAuctions>) login.getShipperAuctionsCollection();
        return list;
    }
    
}
