/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import com.Bean.RegistrationFormBean;
import com.DAO.UserService;
import com.Model.User;
import com.Utils.PasswordDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Harry
 */
@Controller
@RequestMapping(value="/registrasi")
public class Registration {
    
    @Autowired
    UserService us;
    
    @RequestMapping() 
    public String registerForm(Model model) {
        RegistrationFormBean registerBean = new RegistrationFormBean();
        registerBean.setLevel(2);
        model.addAttribute("registerBean", registerBean);
        return "register";
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST) 
    public String saveRegistration(@ModelAttribute("registerBean") RegistrationFormBean registerBean, Model model) {
        
        User user = new User();
        String encryptedPassword = PasswordDigest.createEncryptedPassword(registerBean.getPassword());
       
        user.setNama(registerBean.getNama());
        user.setPassword(encryptedPassword);
        user.setJenisKelamin(registerBean.getJenis_kelamin());
        user.setLevel(registerBean.getLevel());
        user.setTelp(registerBean.getTelp());
        user.setAlamat(registerBean.getAlamat());
        user.setTglLahir(registerBean.getTgl_lahir());
        user.setEmail(registerBean.getEmail());
        user.setUsername(registerBean.getUsername()); 
        user.setImage("user.jpg");
        
        us.saveUser(user);
        
        model.addAttribute("data", registerBean);
        return "redirect:/index";
    }
}
