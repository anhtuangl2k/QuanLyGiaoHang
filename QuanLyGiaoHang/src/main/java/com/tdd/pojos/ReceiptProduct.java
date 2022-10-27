/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "receipt_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiptProduct.findAll", query = "SELECT r FROM ReceiptProduct r"),
    @NamedQuery(name = "ReceiptProduct.findById", query = "SELECT r FROM ReceiptProduct r WHERE r.id = :id"),
    @NamedQuery(name = "ReceiptProduct.findByQuantity", query = "SELECT r FROM ReceiptProduct r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "ReceiptProduct.findByPrice", query = "SELECT r FROM ReceiptProduct r WHERE r.price = :price")})
public class ReceiptProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @JoinColumn(name = "Product_ID", referencedColumnName = "ID")
    @ManyToOne
    private Product productID;
    @JoinColumn(name = "Receipt_ID", referencedColumnName = "ID")
    @ManyToOne
    private Receipt receiptID;

    public ReceiptProduct() {
    }

    public ReceiptProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProductID() {
        return productID;
    }

    public void setProductID(Product productID) {
        this.productID = productID;
    }

    public Receipt getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(Receipt receiptID) {
        this.receiptID = receiptID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceiptProduct)) {
            return false;
        }
        ReceiptProduct other = (ReceiptProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdd.pojos.ReceiptProduct[ id=" + id + " ]";
    }
    
}
