/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.service;

import com.tdd.pojos.Product;
import java.util.List;

public interface ProductService {
    boolean addOrUpdate(Product product);
    Product getProductByID(int ID);
    List<Product> getListProduct(String kw, int page);
    long countProduct();
}
