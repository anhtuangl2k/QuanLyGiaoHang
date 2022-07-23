/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import com.tdd.pojos.Shipper;
import com.tdd.repository.ShipperRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class ShipperRepositoryImpl implements ShipperRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addOrUpdate(Shipper shipper) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(shipper);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<Shipper> getShipperByLoginId(int id) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Login login = session.get(Login.class, id);
//        List<Shipper> test = (List<Shipper>) login.getShipperCollection();
//        return test;  

        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Shipper> q = b.createQuery(Shipper.class);
        Root root = q.from(Shipper.class);
        
        Predicate p = b.equal(root.get("loginId"), id);
        q.where(p);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public Shipper getShipperById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Shipper.class, id);
    }

//    @Override
//    public Shipper getShipperByLoginId2(int id) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Shipper> q = b.createQuery(Shipper.class);
//        Root root = q.from(Shipper.class);
//        
//        Predicate p = b.equal(root.get("loginId"), id);
//        q.where(p);
//        
//        Query query = session.createQuery(q);
//        
//        return query.getSingleResult(Shipper.class);
//    }
    
}
