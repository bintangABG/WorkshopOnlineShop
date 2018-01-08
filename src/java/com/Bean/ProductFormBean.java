/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Team
 */
public class ProductFormBean {
    private String deskripsi;
    private int qty;
    private int id_kategori;
    private double harga;
    private int berat;
    private String nama_product;
    private MultipartFile image;
    private int createdby;
    private int updatedby;
    private Date createddate;
    private Date updateddate;

    /**
     * @return the dekskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the dekskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the id_kategori
     */
    public int getId_kategori() {
        return id_kategori;
    }

    /**
     * @return the image
     */
    public MultipartFile getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(MultipartFile image) {
        this.image = image;
    }

    /**
     * @param id_kategori the id_kategori to set
     */
    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }

    /**
     * @return the berat
     */
    public int getBerat() {
        return berat;
    }

    /**
     * @param berat the berat to set
     */
    public void setBerat(int berat) {
        this.berat = berat;
    }

    /**
     * @return the nama_product
     */
    public String getNama_product() {
        return nama_product;
    }

    /**
     * @param nama_product the nama_product to set
     */
    public void setNama_product(String nama_product) {
        this.nama_product = nama_product;
    }

    /**
     * @return the createdby
     */
    public int getCreatedby() {
        return createdby;
    }

    /**
     * @param createdby the createdby to set
     */
    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    /**
     * @return the updatedby
     */
    public int getUpdatedby() {
        return updatedby;
    }

    /**
     * @param updatedby the updatedby to set
     */
    public void setUpdatedby(int updatedby) {
        this.updatedby = updatedby;
    }

    /**
     * @return the createddate
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * @param createddate the createddate to set
     */
    public void setCreateddate(Date createddate) {
        this.createddate = new Date();
    }

    /**
     * @return the updateddate
     */
    public Date getUpdateddate() {
        return updateddate;
    }

    /**
     * @param updateddate the updateddate to set
     */
    public void setUpdateddate(Date updateddate) {
        this.updateddate = updateddate;
    }

}
