/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Login;
import com.tdd.pojos.Rate;
import com.tdd.repository.RateRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class RateRepositoryImpl implements RateRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Rate addRate(Rate rate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(rate);
            
            return rate;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Rate> getRateByShipperId(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Login login = session.get(Login.class, i);
        List<Rate> test = (List<Rate>) login.getRateCollection();
        return test;
    }
    
}
