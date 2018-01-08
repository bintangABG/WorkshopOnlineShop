/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inteface;

import com.Bean.LoginFormBean;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author user
 */
public interface LoginControllerInterface {
    public String gotoLogin(); //return ke halaman login page
    public String cekLogin(HttpSession session, @ModelAttribute("loginBean") LoginFormBean loginBean, Model model); 
    //method buat cek login if true -> return welcome else ->return login
}
