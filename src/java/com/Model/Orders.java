/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tbl_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByIdOrder", query = "SELECT o FROM Orders o WHERE o.idOrder = :idOrder")
    , @NamedQuery(name = "Orders.findByPpn", query = "SELECT o FROM Orders o WHERE o.ppn = :ppn")
    , @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total")
    , @NamedQuery(name = "Orders.findByIsCredit", query = "SELECT o FROM Orders o WHERE o.isCredit = :isCredit")
    , @NamedQuery(name = "Orders.findByCreatedby", query = "SELECT o FROM Orders o WHERE o.createdby = :createdby")
    , @NamedQuery(name = "Orders.findByUpdatedby", query = "SELECT o FROM Orders o WHERE o.updatedby = :updatedby")
    , @NamedQuery(name = "Orders.findByCreateddate", query = "SELECT o FROM Orders o WHERE o.createddate = :createddate")
    , @NamedQuery(name = "Orders.findByUpdateddate", query = "SELECT o FROM Orders o WHERE o.updateddate = :updateddate")})
public class Orders implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrder")
    private List<Payment> tblPaymentList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    @Basic(optional = false)
    @Column(name = "ppn")
    private double ppn;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @Column(name = "isCredit")
    private int isCredit;
    @Basic(optional = false)
    @Column(name = "createdby")
    private int createdby;
    @Basic(optional = false)
    @Column(name = "updatedby")
    private int updatedby;
    @Basic(optional = false)
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Basic(optional = false)
    @Column(name = "updateddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateddate;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrder")
    private List<Items> itemsList;

    public Orders() {
    }

    public Orders(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Orders(Integer idOrder, double ppn, double total, int isCredit, int createdby, int updatedby, Date createddate, Date updateddate) {
        this.idOrder = idOrder;
        this.ppn = ppn;
        this.total = total;
        this.isCredit = isCredit;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.createddate = createddate;
        this.updateddate = updateddate;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public double getPpn() {
        return ppn;
    }

    public void setPpn(double ppn) {
        this.ppn = ppn;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(int isCredit) {
        this.isCredit = isCredit;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public int getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(int updatedby) {
        this.updatedby = updatedby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Model.Orders[ idOrder=" + idOrder + " ]";
    }

    @XmlTransient
    public List<Payment> getTblPaymentList() {
        return tblPaymentList;
    }

    public void setTblPaymentList(List<Payment> tblPaymentList) {
        this.tblPaymentList = tblPaymentList;
    }
    
}
