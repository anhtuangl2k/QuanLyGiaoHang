/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Login;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.tdd.repository.LoginRepository;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class LoginRepositoryImpl implements LoginRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addLogin(Login user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(user);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public boolean addUserRoleShipper(Login shipper) {
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
    public List<Login> getLogin(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);
        Root root = query.from(Login.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Login getLoginById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Login.class, id);
    }

    @Override
    public List<Login> getLoginByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);
        Root root = query.from(Login.class);
        query = query.select(root);

        if (!username.isEmpty() && username != null) {
            Predicate p = builder.like(root.get("username").as(String.class),
                    String.format("%s", username));
            query = query.where(p);
        }

        Query q = s.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<Login> getLoginByPhone(String string) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);
        Root root = query.from(Login.class);
        query = query.select(root);

        if (!string.isEmpty() && string != null) {
            Predicate p = builder.like(root.get("phone").as(String.class),
                    String.format("%s", string));
            query = query.where(p);

        }

        Query q = s.createQuery(query);
        return q.getResultList();

    }

    @Override
    public List<Login> getLoginByEmail(String string) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Login> query = builder.createQuery(Login.class);
        Root root = query.from(Login.class);
        query = query.select(root);

        if (!string.isEmpty() && string != null) {
            Predicate p = builder.like(root.get("email").as(String.class),
                    String.format("%s", string));
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Login setUserRole(Login login) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(login);

            return login;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return null;    }

}
