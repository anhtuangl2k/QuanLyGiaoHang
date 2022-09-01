/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tdd.pojos.Product;
import com.tdd.repository.ProductRepository;
import com.tdd.service.ProductService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public boolean addOrUpdate(Product product) {
        try { 
            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            product.setImage((String) r.get("secure_url"));
            System.out.println((String) r.get("secure_url"));
            return this.productRepository.addOrUpdate(product);
        } catch (IOException ex) {
            Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Product getProductByID(int ID) {        
        return this.productRepository.getProductByID(ID);
    }
    
}
