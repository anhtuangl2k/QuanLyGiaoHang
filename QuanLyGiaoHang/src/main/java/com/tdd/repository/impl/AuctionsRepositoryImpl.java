/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Auctions;
import com.tdd.repository.AuctionsRepository;
import org.hibernate.HibernateException;
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
public class AuctionsRepositoryImpl implements AuctionsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addOrUpdate(Auctions auctions) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(auctions);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public Auctions addAuctions(Auctions au) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(au);

            return au;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
