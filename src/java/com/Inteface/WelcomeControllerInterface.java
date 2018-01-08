/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inteface;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author user
 */
public interface WelcomeControllerInterface {
    public String gotoWelcomePage(Model model,ModelMap models);//return ke welcome page
    public String logOut(HttpSession session, Model model); //return ke welcome page
    public String searchProduct(@RequestParam("keyword")String keyword,Model model); //return ke halaman search
}
