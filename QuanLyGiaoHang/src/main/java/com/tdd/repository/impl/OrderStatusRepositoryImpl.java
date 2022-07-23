/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.OrderStatus;
import com.tdd.repository.OrderStatusRepository;
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
public class OrderStatusRepositoryImpl implements OrderStatusRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public OrderStatus getOrderStatusById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(OrderStatus.class, id);
    }
    
}
