/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Product;
import com.tdd.pojos.Receipt;
import com.tdd.pojos.ReceiptProduct;
import com.tdd.repository.ReceiptResponsitory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Path.Node;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReceiptResponsitoryImpl implements ReceiptResponsitory{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addReceipt(Receipt receipt) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(receipt);                
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Receipt> listReceiptOfGuest(Integer id, Integer status) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Receipt> query = builder.createQuery(Receipt.class);
        Root root = query.from(Receipt.class);
        query = query.select(root);
        if(id != null){
            Predicate p = builder.like(root.get("guestID").get("id").as(String.class), 
            String.format("%%%s%%", id));
            query = query.where(p);
        }
        if(status != null){
            Predicate p = builder.equal(root.get("status"), status);
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);        
        return q.getResultList();
    }

    @Override
    public Receipt getReceiptById(Integer id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Receipt.class, id);
    }

    @Override
    public boolean updateReceipt(Receipt r) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(r);                
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Object[]> receiptStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootP = query.from(Product.class);
        Root rootR = query.from(Receipt.class);
        Root rootPR = query.from(ReceiptProduct.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootPR.get("productID"), rootP.get("id")));
        predicates.add(builder.equal(rootPR.get("receiptID"), rootR.get("id")));
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(builder.like(rootP.get("name"), kw));
        }
        if(fromDate != null){
            predicates.add(builder.greaterThanOrEqualTo(rootR.get("dateTime"), fromDate));
        }
        if(toDate != null){
            predicates.add(builder.lessThanOrEqualTo(rootR.get("dateTime"), toDate));
        }
        
        query.multiselect(rootP.get("id"), rootP.get("name"),
                builder.sum(builder.prod(rootPR.get("price"), rootPR.get("quantity"))));
        query.where(predicates.toArray(new Predicate[] {}));
        
        query.groupBy(rootP.get("id"));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
