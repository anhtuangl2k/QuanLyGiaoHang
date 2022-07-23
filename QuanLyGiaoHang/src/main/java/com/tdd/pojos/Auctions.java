/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "auctions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auctions.findAll", query = "SELECT a FROM Auctions a"),
    @NamedQuery(name = "Auctions.findById", query = "SELECT a FROM Auctions a WHERE a.id = :id"),
    @NamedQuery(name = "Auctions.findByPrice", query = "SELECT a FROM Auctions a WHERE a.price = :price"),
    @NamedQuery(name = "Auctions.findByCreatedDate", query = "SELECT a FROM Auctions a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "Auctions.findByContent", query = "SELECT a FROM Auctions a WHERE a.content = :content")})
public class Auctions implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 200)
    @Column(name = "content")
    private String content;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctionsId")
    private Collection<ShipperAuctions> shipperAuctionsCollection;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderDetail orderId;
    @JoinColumn(name = "shipper_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Shipper shipperId;
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Login loginId;

    public Auctions() {
    }

    public Auctions(Integer id) {
        this.id = id;
    }

    public Auctions(Integer id, long price, Date createdDate) {
        this.id = id;
        this.price = price;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public Collection<ShipperAuctions> getShipperAuctionsCollection() {
        return shipperAuctionsCollection;
    }

    public void setShipperAuctionsCollection(Collection<ShipperAuctions> shipperAuctionsCollection) {
        this.shipperAuctionsCollection = shipperAuctionsCollection;
    }

    public OrderDetail getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderDetail orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof Auctions)) {
            return false;
        }
        Auctions other = (Auctions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdd.pojos.Auctions[ id=" + id + " ]";
    }

}
