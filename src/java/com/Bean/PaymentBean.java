/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

/**
 *
 * @author user
 */
public class PaymentBean {

    /**
     * @return the gaji_pokok
     */
    public double getGaji_pokok() {
        return gaji_pokok;
    }

    /**
     * @param gaji_pokok the gaji_pokok to set
     */
    public void setGaji_pokok(double gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }

    /**
     * @return the penghasilan_tambahan
     */
    public double getPenghasilan_tambahan() {
        return penghasilan_tambahan;
    }

    /**
     * @param penghasilan_tambahan the penghasilan_tambahan to set
     */
    public void setPenghasilan_tambahan(double penghasilan_tambahan) {
        this.penghasilan_tambahan = penghasilan_tambahan;
    }

    /**
     * @return the uang_muka
     */
    public double getUang_muka() {
        return uang_muka;
    }

    /**
     * @param uang_muka the uang_muka to set
     */
    public void setUang_muka(double uang_muka) {
        this.uang_muka = uang_muka;
    }

    /**
     * @return the tanggungan
     */
    public int getTanggungan() {
        return tanggungan;
    }

    /**
     * @param tanggungan the tanggungan to set
     */
    public void setTanggungan(int tanggungan) {
        this.tanggungan = tanggungan;
    }

    /**
     * @return the isAsuransi
     */
    public int getIsAsuransi() {
        return isAsuransi;
    }

    /**
     * @param isAsuransi the isAsuransi to set
     */
    public void setIsAsuransi(int isAsuransi) {
        this.isAsuransi = isAsuransi;
    }
    private int credit;
    private String jenis_paket;
    private String kota_tujuan;
    private int isAsuransi;
    private double gaji_pokok;
    private double penghasilan_tambahan;
    private double uang_muka;
    private int tanggungan;

    /**
     * @return the credit
     */
    public int getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /**
     * @return the jenis_paket
     */
    public String getJenis_paket() {
        return jenis_paket;
    }

    /**
     * @param jenis_paket the jenis_paket to set
     */
    public void setJenis_paket(String jenis_paket) {
        this.jenis_paket = jenis_paket;
    }

    /**
     * @return the kota_tujuan
     */
    public String getKota_tujuan() {
        return kota_tujuan;
    }

    /**
     * @param kota_tujuan the kota_tujuan to set
     */
    public void setKota_tujuan(String kota_tujuan) {
        this.kota_tujuan = kota_tujuan;
    }

}
