/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inteface;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author user
 */
public interface ProductControllerInterface {
    public String showAllProdcut(ModelMap model); //return ke index
    public String showAllByKategori(@PathVariable("kategori")String kategori,ModelMap model); //return buat tampilin product berdasatkan kategori
    public String detailProduct(@PathVariable("id")Integer id,Model model); //detail product
}
