/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inteface;

import com.Bean.RegistrationFormBean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author user
 */
public interface RegisterControllerInterface {
    public String gotoRegister(Model model);//return ke halaman register
    public String saveUser(@ModelAttribute("registerBean")RegistrationFormBean registerBean,BindingResult result,Model model); // return ke halaman login
}
