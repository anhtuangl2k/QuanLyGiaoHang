/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tdd.repository.OrderRepository;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addOrUpdate(OrderDetail order) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(order);

            return true;
        } catch (Exception ex) {
            System.err.print("=== ADD ORDER ERROR ===" + ex.getMessage());
        }

        return false;
    }

    @Override
    public List<OrderDetail> getOrderDetail() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.getNamedQuery("OrderDetail.findAll");
        
        return query.getResultList();
    }

    @Override
    public List<OrderDetail> getOrderByUserId(int i) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Login login = session.get(Login.class, i);
        List<OrderDetail> test = (List<OrderDetail>) login.getOrderDetailCollection();
        return test;    
    }

    @Override
    public OrderDetail getOrderById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(OrderDetail.class, id);
    }

}
