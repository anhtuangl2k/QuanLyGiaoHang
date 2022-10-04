/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Product;
import com.tdd.pojos.Receipt;
import com.tdd.repository.ReceiptResponsitory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Receipt> listReceiptOfGuest(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Receipt> query = builder.createQuery(Receipt.class);
        Root root = query.from(Receipt.class);
        query = query.select(root);
        

        Predicate p = builder.like(root.get("guestID").get("id").as(String.class), 
                String.format("%%%s%%", id));
        query = query.where(p);
        
        Query q = session.createQuery(query);        
        return q.getResultList();
    }
    
}
