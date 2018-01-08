/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import com.DAO.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Team
 */
@Controller
@RequestMapping("/index")
public class indexController {
    @Autowired
    ProductService ps;
    
    @RequestMapping()
    public String gotoIndex(ModelMap katalog)
    {
        katalog.put("products", ps.showAllProdctoffset());
        return "index";
    }
}
