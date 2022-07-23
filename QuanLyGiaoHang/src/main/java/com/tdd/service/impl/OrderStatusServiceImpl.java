/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.service.impl;

import com.tdd.pojos.OrderStatus;
import com.tdd.repository.OrderStatusRepository;
import com.tdd.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService{
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus getOrderStatusById(int id) {
        return this.orderStatusRepository.getOrderStatusById(id);
    }
    
}
