/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Auctions;
import com.tdd.pojos.Login;
import com.tdd.pojos.OrderDetail;
import com.tdd.pojos.OrderStatus;
import com.tdd.pojos.Shipper;
import com.tdd.pojos.ShipperAuctions;
import com.tdd.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> statsShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootS = q.from(Shipper.class);
        Root rootL = q.from(Login.class);

        q.where(b.equal(rootS.get("loginId"), rootL.get("id")));

        q.multiselect(rootS.get("idCardNumber"), rootL.get("fullName"),
                rootL.get("address"), rootL.get("email"), rootL.get("phone"),
                rootL.get("id"), rootS.get("id"), rootL.get("userRole"), rootS.get("type"));

        q.groupBy(rootS.get("loginId"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> starsOrder() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootO = q.from(OrderDetail.class);
        Root rootS = q.from(OrderStatus.class);
        
        q.where(b.equal(rootO.get("orderStatusId"), rootS.get("id")));
        
        q.multiselect(rootS.get("id"), rootS.get("name"),
                b.count(rootO.get("id")));
        
        q.groupBy(rootS.get("id"));
        
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> searchOrder(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootO = q.from(OrderDetail.class);
        Root rootA = q.from(Auctions.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootO.get("id"), rootA.get("orderId")));
        
        q.multiselect(rootO.get("id"), rootO.get("nameProduct"));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootO.get("nameProduct").as(String.class), 
                   String.format("%%%s%%", kw))) ;
            
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rootO.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<OrderDetail> searchOrder2(String kw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<OrderDetail> query = builder.createQuery(OrderDetail.class);
        Root root = query.from(OrderDetail.class);
        query = query.select(root);

        if (!kw.isEmpty() && kw != null) {
            Predicate p = builder.like(root.get("nameProduct").as(String.class),
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }

        Query q = s.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<Object[]> statsRevenue() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootS = q.from(Shipper.class);
        Root rootSA = q.from(ShipperAuctions.class);
        Root rootA = q.from(Auctions.class);
        Root rootL = q.from(Login.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootS.get("id"), rootA.get("shipperId")));
        predicates.add(b.equal(rootA.get("id"), rootSA.get("auctionsId")));
        predicates.add(b.equal(rootL.get("id"), rootS.get("loginId")));
        
        q.multiselect(rootS.get("id"), rootL.get("fullName"),
                b.sum(rootA.get("price")), b.count(rootSA.get("id")));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rootS.get("id"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();   
    }

}
