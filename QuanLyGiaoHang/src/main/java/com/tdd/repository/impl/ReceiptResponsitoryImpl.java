/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Receipt;
import com.tdd.repository.ReceiptResponsitory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReceiptResponsitoryImpl implements ReceiptResponsitory{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addReceipt(Receipt receipt) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(receipt);                
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }
    
}
