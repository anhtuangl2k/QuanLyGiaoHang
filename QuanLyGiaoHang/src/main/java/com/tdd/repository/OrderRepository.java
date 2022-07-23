/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.repository;

import com.tdd.pojos.OrderDetail;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderRepository {
    boolean addOrUpdate(OrderDetail order);
    List<OrderDetail> getOrderDetail();
    OrderDetail getOrderById(int id);
    List<OrderDetail> getOrderByUserId(int userId);
}
