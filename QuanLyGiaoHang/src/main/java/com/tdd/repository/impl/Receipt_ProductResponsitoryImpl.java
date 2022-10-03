/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository.impl;

import com.tdd.pojos.ReceiptProduct;
import com.tdd.repository.Receipt_ProductResponsitory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Receipt_ProductResponsitoryImpl implements Receipt_ProductResponsitory{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addReceipt_Product(ReceiptProduct r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(r);                
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }
}
