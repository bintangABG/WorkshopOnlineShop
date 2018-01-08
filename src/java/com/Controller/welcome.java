/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;


import com.Bean.PaymentBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *  @author Team
 */

@Controller
@RequestMapping("/welcome")
public class welcome{
    
    @RequestMapping()
    public String teskeranjang(@ModelAttribute("paymentbean")PaymentBean paymentbean)
    {
        return "teskeranjang";
    }
}
