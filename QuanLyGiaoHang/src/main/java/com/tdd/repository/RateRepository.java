/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tdd.repository;

import com.tdd.pojos.Rate;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RateRepository {
    Rate addRate(Rate rate);
    List<Rate> getRateByShipperId(int id);
}
