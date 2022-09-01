/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.repository.impl;

import com.tdd.pojos.Discount;
import com.tdd.pojos.Product;
import com.tdd.repository.ProductRepository;
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

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addOrUpdate(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if(product.getId() == null){
                System.out.println("ADD PRODUCT");
                session.save(product);
            }
            else{
                System.out.println("UPDATE PRODUCT");
                session.update(product);
            }
                
            return true;
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        return false;
    }

    @Override
    public Product getProductByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public List<Product> getListProduct(String kw, int page) {
                Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("name").as(String.class), 
                    String.format("%%%s%%", kw));
        }
        
        Query q = session.createQuery(query);
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1)*max);
        
        return q.getResultList();
    }

    @Override
    public long countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("Select Count(*) From Product");        
        return Long.parseLong(q.getSingleResult().toString());
    }
    
}
