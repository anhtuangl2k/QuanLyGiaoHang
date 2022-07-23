/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.pojos;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "orderdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o"),
    @NamedQuery(name = "OrderDetail.findById", query = "SELECT o FROM OrderDetail o WHERE o.id = :id"),
    @NamedQuery(name = "OrderDetail.findByNameProduct", query = "SELECT o FROM OrderDetail o WHERE o.nameProduct = :nameProduct"),
    @NamedQuery(name = "OrderDetail.findBySenderAddress", query = "SELECT o FROM OrderDetail o WHERE o.senderAddress = :senderAddress"),
    @NamedQuery(name = "OrderDetail.findBySenderName", query = "SELECT o FROM OrderDetail o WHERE o.senderName = :senderName"),
    @NamedQuery(name = "OrderDetail.findBySenderPhone", query = "SELECT o FROM OrderDetail o WHERE o.senderPhone = :senderPhone"),
    @NamedQuery(name = "OrderDetail.findByRecipientAddress", query = "SELECT o FROM OrderDetail o WHERE o.recipientAddress = :recipientAddress"),
    @NamedQuery(name = "OrderDetail.findByRecipientName", query = "SELECT o FROM OrderDetail o WHERE o.recipientName = :recipientName"),
    @NamedQuery(name = "OrderDetail.findByRecipientPhone", query = "SELECT o FROM OrderDetail o WHERE o.recipientPhone = :recipientPhone")
})
public class OrderDetail implements Serializable {

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the orderStatusId
     */
    public OrderStatus getOrderStatusId() {
        return orderStatusId;
    }

    /**
     * @param orderStatusId the orderStatusId to set
     */
    public void setOrderStatusId(OrderStatus orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    /**
     * @return the auctionsCollection
     */
    public Collection<Auctions> getAuctionsCollection() {
        return auctionsCollection;
    }

    /**
     * @param auctionsCollection the auctionsCollection to set
     */
    public void setAuctionsCollection(Collection<Auctions> auctionsCollection) {
        this.auctionsCollection = auctionsCollection;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.nameProduct.nullMsg}")
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "created_date")
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.senderAddress.nullMsg}")
    @Column(name = "sender_address")
    private String senderAddress;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.senderName.nullMsg}")
    @Column(name = "sender_name")
    private String senderName;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.senderPhone.nullMsg}")
    @Column(name = "sender_phone")
    private String senderPhone;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.recipientAddress.nullMsg}")
    @Column(name = "recipient_address")
    private String recipientAddress;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.recipientName.nullMsg}")
    @Column(name = "recipient_name")
    private String recipientName;
    @Basic(optional = false)
    @Size(min = 1, message = "{order.recipientPhone.nullMsg}")
    @Column(name = "recipient_phone")
    private String recipientPhone;
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Login loginId;
    @JoinColumn(name = "orderstatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrderStatus orderStatusId;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( mappedBy = "orderId")
    private Collection<Auctions> auctionsCollection;

    public OrderDetail() {
        createdDate = new Date();
    }

    public OrderDetail(Integer id) {
        this.id = id;
    }

    public OrderDetail(Integer id, String nameProduct, String senderAddress, String senderName, String senderPhone, String recipientAddress, String recipientName, String recipientPhone) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.senderAddress = senderAddress;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login userId) {
        this.loginId = userId;
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
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdd.pojos.OrderDetail[ id=" + id + " ]";
    }
}
