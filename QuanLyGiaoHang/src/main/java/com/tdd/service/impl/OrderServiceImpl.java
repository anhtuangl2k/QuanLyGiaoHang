/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import com.tdd.pojos.OrderStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tdd.repository.OrderRepository;
import com.tdd.repository.OrderStatusRepository;
import com.tdd.service.OrderService;

/**
 *
 * @author Admin
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public boolean addOrUpdate(OrderDetail order) {
        OrderStatus o = this.orderStatusRepository.getOrderStatusById(1);
        
        order.setOrderStatusId(o);
        
        return this.orderRepository.addOrUpdate(order);
    }

    @Override
    public List<OrderDetail> getOrderDetail() {
        return this.orderRepository.getOrderDetail();
    }

    @Override
    public List<OrderDetail> getOrderByUserId(int i) {
        return this.orderRepository.getOrderByUserId(i);
    }

    @Override
    public OrderDetail getOrderById(int id) {
        return this.orderRepository.getOrderById(id);
    }
    
}
