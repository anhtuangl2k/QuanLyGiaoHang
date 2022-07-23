/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.service;

import com.tdd.pojos.OrderDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatsService {
    List<Object[]> statsShipper();
    List<Object[]> starsOrder();
    List<Object[]> searchOrder(String kw, Date fromDate, Date toDate);
    List<OrderDetail> searchOrder2(String kw);
    List<Object[]> statsRevenue();
}
