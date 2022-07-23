/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tdd.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findById", query = "SELECT l FROM Login l WHERE l.id = :id"),
    @NamedQuery(name = "Login.findByFullName", query = "SELECT l FROM Login l WHERE l.fullName = :fullName"),
    @NamedQuery(name = "Login.findByUsername", query = "SELECT l FROM Login l WHERE l.username = :username"),
    @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password"),
    @NamedQuery(name = "Login.findByAddress", query = "SELECT l FROM Login l WHERE l.address = :address"),
    @NamedQuery(name = "Login.findByEmail", query = "SELECT l FROM Login l WHERE l.email = :email"),
    @NamedQuery(name = "Login.findByPhone", query = "SELECT l FROM Login l WHERE l.phone = :phone"),
    @NamedQuery(name = "Login.findByAvatar", query = "SELECT l FROM Login l WHERE l.avatar = :avatar"),
    @NamedQuery(name = "Login.findByUserRole", query = "SELECT l FROM Login l WHERE l.userRole = :userRole")})
public class Login implements Serializable {

    /**
     * @return the shipperAuctionsCollection
     */
    public Collection<ShipperAuctions> getShipperAuctionsCollection() {
        return shipperAuctionsCollection;
    }

    /**
     * @param shipperAuctionsCollection the shipperAuctionsCollection to set
     */
    public void setShipperAuctionsCollection(Collection<ShipperAuctions> shipperAuctionsCollection) {
        this.shipperAuctionsCollection = shipperAuctionsCollection;
    }

    /**
     * @return the orderDetailCollection
     */
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    /**
     * @param orderDetailCollection the orderDetailCollection to set
     */
    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    /**
     * @return the shipperCollection
     */
    public Collection<Shipper> getShipperCollection() {
        return shipperCollection;
    }

    /**
     * @param shipperCollection the shipperCollection to set
     */
    public void setShipperCollection(Collection<Shipper> shipperCollection) {
        this.shipperCollection = shipperCollection;
    }

    /**
     * @return the rateCollection
     */
    public Collection<Rate> getRateCollection() {
        return rateCollection;
    }

    /**
     * @param rateCollection the rateCollection to set
     */
    public void setRateCollection(Collection<Rate> rateCollection) {
        this.rateCollection = rateCollection;
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

    @OneToMany( mappedBy = "loginId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<OrderDetail> orderDetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginId" )
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Shipper> shipperCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( mappedBy = "loginId" )
    private Collection<Rate> rateCollection;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany( mappedBy = "loginId" )
    @JsonIgnore
    private Collection<Auctions> auctionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loginId" )
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ShipperAuctions> shipperAuctionsCollection;

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    public static final String SHIPPER = "ROLE_SHIPPER";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, message = "{login.fullName.nullMsg}")
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, message = "{login.username.nullMsg}")
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, message = "{login.password.nullMsg}")
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, message = "{login.address.nullMsg}")
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, message = "{login.email.nullMsg}")
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, message = "{login.phone.nullMsg}")
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_role")
    private String userRole;
    @Transient
    @JsonIgnore
    private String confirmPassword;
    @Transient
    private MultipartFile file;

    public Login() {
    }

    public Login(Integer id) {
        this.id = id;
    }

    public Login(Integer id, String fullName, String username, String password, String address, String email, String phone, String avatar, String userRole) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdd.pojos.Login[ id=" + id + " ]";
    }

}
