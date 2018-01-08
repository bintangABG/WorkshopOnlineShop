/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Team
 */
@Controller
@RequestMapping("/logout")
public class Logout {
    
    @RequestMapping()
    public String letsGoOut(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index";
    }
    
}
