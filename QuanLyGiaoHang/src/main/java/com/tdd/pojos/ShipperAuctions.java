/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "shipper_auctions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShipperAuctions.findAll", query = "SELECT s FROM ShipperAuctions s"),
    @NamedQuery(name = "ShipperAuctions.findById", query = "SELECT s FROM ShipperAuctions s WHERE s.id = :id"),
    @NamedQuery(name = "ShipperAuctions.findByCreatedDate", query = "SELECT s FROM ShipperAuctions s WHERE s.createdDate = :createdDate"),
 })
public class ShipperAuctions implements Serializable {

    /**
     * @return the loginId
     */
    public Login getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "auctions_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Auctions auctionsId;
    @JoinColumn(name = "shipper_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shipper shipperId;
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Login loginId;

    public ShipperAuctions() {
    }

    public ShipperAuctions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date orderReceiptDate) {
        this.createdDate = orderReceiptDate;
    }

    public Auctions getAuctionsId() {
        return auctionsId;
    }

    public void setAuctionsId(Auctions auctionsId) {
        this.auctionsId = auctionsId;
    }

    public Shipper getShipperId() {
        return shipperId;
    }

    public void setShipperId(Shipper shipperId) {
        this.shipperId = shipperId;
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
        if (!(object instanceof ShipperAuctions)) {
            return false;
        }
        ShipperAuctions other = (ShipperAuctions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdd.pojos.ShipperAuctions[ id=" + id + " ]";
    }
    
}
