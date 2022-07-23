/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.service;

import com.tdd.pojos.Login;
import com.tdd.pojos.Rate;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RateService {
    Rate addRate(String comment, int rating, int shipperId, Login loginId);
    List<Rate> getRateByShipperId(int id);
}
