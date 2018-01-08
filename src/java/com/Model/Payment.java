/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tbl_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment")
    , @NamedQuery(name = "Payment.findByAsuransiPengiriman", query = "SELECT p FROM Payment p WHERE p.asuransiPengiriman = :asuransiPengiriman")
    , @NamedQuery(name = "Payment.findByGajiPokok", query = "SELECT p FROM Payment p WHERE p.gajiPokok = :gajiPokok")
    , @NamedQuery(name = "Payment.findByTanggungan", query = "SELECT p FROM Payment p WHERE p.tanggungan = :tanggungan")
    , @NamedQuery(name = "Payment.findByPenghasilanTambahan", query = "SELECT p FROM Payment p WHERE p.penghasilanTambahan = :penghasilanTambahan")
    , @NamedQuery(name = "Payment.findByUangMuka", query = "SELECT p FROM Payment p WHERE p.uangMuka = :uangMuka")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment")
    private Integer idPayment;
    @Basic(optional = false)
    @Lob
    @Column(name = "tujuan_pengiriman")
    private String tujuanPengiriman;
    @Basic(optional = false)
    @Column(name = "asuransi_pengiriman")
    private Character asuransiPengiriman;
    @Basic(optional = false)
    @Lob
    @Column(name = "jenis_pengiriman")
    private String jenisPengiriman;
    @Basic(optional = false)
    @Column(name = "gaji_pokok")
    private double gajiPokok;
    @Basic(optional = false)
    @Column(name = "tanggungan")
    private int tanggungan;
    @Basic(optional = false)
    @Column(name = "penghasilan_tambahan")
    private double penghasilanTambahan;
    @Basic(optional = false)
    @Column(name = "uang_muka")
    private double uangMuka;
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    @ManyToOne(optional = false)
    private Orders idOrder;

    public Payment() {
    }

    public Payment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Payment(Integer idPayment, String tujuanPengiriman, Character asuransiPengiriman, String jenisPengiriman, double gajiPokok, int tanggungan, double penghasilanTambahan, double uangMuka) {
        this.idPayment = idPayment;
        this.tujuanPengiriman = tujuanPengiriman;
        this.asuransiPengiriman = asuransiPengiriman;
        this.jenisPengiriman = jenisPengiriman;
        this.gajiPokok = gajiPokok;
        this.tanggungan = tanggungan;
        this.penghasilanTambahan = penghasilanTambahan;
        this.uangMuka = uangMuka;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getTujuanPengiriman() {
        return tujuanPengiriman;
    }

    public void setTujuanPengiriman(String tujuanPengiriman) {
        this.tujuanPengiriman = tujuanPengiriman;
    }

    public Character getAsuransiPengiriman() {
        return asuransiPengiriman;
    }

    public void setAsuransiPengiriman(Character asuransiPengiriman) {
        this.asuransiPengiriman = asuransiPengiriman;
    }

    public String getJenisPengiriman() {
        return jenisPengiriman;
    }

    public void setJenisPengiriman(String jenisPengiriman) {
        this.jenisPengiriman = jenisPengiriman;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public int getTanggungan() {
        return tanggungan;
    }

    public void setTanggungan(int tanggungan) {
        this.tanggungan = tanggungan;
    }

    public double getPenghasilanTambahan() {
        return penghasilanTambahan;
    }

    public void setPenghasilanTambahan(double penghasilanTambahan) {
        this.penghasilanTambahan = penghasilanTambahan;
    }

    public double getUangMuka() {
        return uangMuka;
    }

    public void setUangMuka(double uangMuka) {
        this.uangMuka = uangMuka;
    }

    public Orders getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Orders idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayment != null ? idPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idPayment == null && other.idPayment != null) || (this.idPayment != null && !this.idPayment.equals(other.idPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Model.Payment[ idPayment=" + idPayment + " ]";
    }
    
}
