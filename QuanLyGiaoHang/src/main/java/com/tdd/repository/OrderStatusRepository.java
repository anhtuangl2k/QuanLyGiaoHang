/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.repository;

import com.tdd.pojos.OrderStatus;

/**
 *
 * @author Admin
 */
public interface OrderStatusRepository {
    OrderStatus getOrderStatusById(int id);
}
