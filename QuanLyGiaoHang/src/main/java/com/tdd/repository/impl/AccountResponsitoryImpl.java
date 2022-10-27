/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Account;
import com.tdd.repository.AccountResponsitory;
import java.util.List;
import java.util.stream.Stream;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountResponsitoryImpl implements AccountResponsitory{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
        
    @Override
    public boolean addAccount(Account account) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(account);
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Account> getListAccountShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query = query.select(root).where(builder.equal(root.get("status"), Account.DISABLE));
        Query q = session.createQuery(query);
        List<Account> list = q.getResultList();
        return list;
    }

    @Override
    public Account getAccountByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Account.class, id);
    }

    @Override
    public boolean changeStatus(int id) {
        try {
            Account a = getAccountByID(id);
            a.setStatus(Account.ENABLE);
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Account> getAccounts(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();       
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query = query.select(root);
        
        if(!username.isEmpty()){
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }       
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Account> listGuest() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();       
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query = query.select(root);
        
        Predicate p = builder.equal(root.get("type"), Account.GUEST);
        
        query = query.where(p);  
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Account> listShipper() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();       
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query = query.select(root);
        
        Predicate p = builder.equal(root.get("type"), Account.SHIPPER);
        
        query = query.where(p);  
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
