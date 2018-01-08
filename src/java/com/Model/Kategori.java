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
@Table(name = "tbl_kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k")
    , @NamedQuery(name = "Kategori.findByIdKetegori", query = "SELECT k FROM Kategori k WHERE k.idKetegori = :idKetegori")
    , @NamedQuery(name = "Kategori.findByKategori", query = "SELECT k FROM Kategori k WHERE k.kategori = :kategori")
    , @NamedQuery(name = "Kategori.findByCreatedby", query = "SELECT k FROM Kategori k WHERE k.createdby = :createdby")
    , @NamedQuery(name = "Kategori.findByUpdatedby", query = "SELECT k FROM Kategori k WHERE k.updatedby = :updatedby")
    , @NamedQuery(name = "Kategori.findByCreateddate", query = "SELECT k FROM Kategori k WHERE k.createddate = :createddate")
    , @NamedQuery(name = "Kategori.findByUpdateddate", query = "SELECT k FROM Kategori k WHERE k.updateddate = :updateddate")})
public class Kategori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ketegori")
    private Integer idKetegori;
    @Basic(optional = false)
    @Column(name = "kategori")
    private String kategori;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKategori")
    private List<Product> productList;

    public Kategori() {
    }

    public Kategori(Integer idKetegori) {
        this.idKetegori = idKetegori;
    }

    public Kategori(Integer idKetegori, String kategori, int createdby, int updatedby, Date createddate, Date updateddate) {
        this.idKetegori = idKetegori;
        this.kategori = kategori;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.createddate = createddate;
        this.updateddate = updateddate;
    }

    public Integer getIdKetegori() {
        return idKetegori;
    }

    public void setIdKetegori(Integer idKetegori) {
        this.idKetegori = idKetegori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKetegori != null ? idKetegori.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.idKetegori == null && other.idKetegori != null) || (this.idKetegori != null && !this.idKetegori.equals(other.idKetegori))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Model.Kategori[ idKetegori=" + idKetegori + " ]";
    }
    
}
