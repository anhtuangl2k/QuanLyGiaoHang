/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anhtu
 */
@Entity
@Table(name = "receipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r"),
    @NamedQuery(name = "Receipt.findById", query = "SELECT r FROM Receipt r WHERE r.id = :id"),
    @NamedQuery(name = "Receipt.findByAmount", query = "SELECT r FROM Receipt r WHERE r.amount = :amount"),
    @NamedQuery(name = "Receipt.findByDateTime", query = "SELECT r FROM Receipt r WHERE r.dateTime = :dateTime")})
public class Receipt implements Serializable {

    @OneToMany(mappedBy = "receiptsID", fetch = FetchType.EAGER)
    private Collection<Comment> commentCollection;

    @JoinColumn(name = "Discount_ID", referencedColumnName = "ID")
    @ManyToOne
    private Discount discountID;

    public static int CHUA_GIAO = 0;
    public static int DANG_GIAO = 1;
    public static int DA_GIAO = 2;
    
    @Column(name = "Status")
    private Integer status;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Amount")
    private Double amount;
    @Column(name = "DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JsonIgnore
    @JoinColumn(name = "Guest_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account guestID;
    @JsonIgnore
    @JoinColumn(name = "Shipper_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account shipperID;
    @JsonIgnore
    @OneToMany(mappedBy = "receiptID")
    private Collection<ReceiptProduct> receiptProductCollection;

    public Receipt() {
        dateTime = new Date();
    }

    public Receipt(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Account getGuestID() {
        return guestID;
    }

    public void setGuestID(Account guestID) {
        this.guestID = guestID;
    }

    public Account getShipperID() {
        return shipperID;
    }

    public void setShipperID(Account shipperID) {
        this.shipperID = shipperID;
    }

    @XmlTransient
    public Collection<ReceiptProduct> getReceiptProductCollection() {
        return receiptProductCollection;
    }

    public void setReceiptProductCollection(Collection<ReceiptProduct> receiptProductCollection) {
        this.receiptProductCollection = receiptProductCollection;
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
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdd.pojos.Receipt[ id=" + id + " ]";
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Discount getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Discount discountID) {
        this.discountID = discountID;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }
    
}
