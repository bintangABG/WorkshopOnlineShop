/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.Model.Items;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Team
 */
public class CartBean {
    private Map<Integer, Items> cartlist = new HashMap<>();

    public CartBean() {
    }

    /**
     * @return the cartlist
     */
    public Map<Integer, Items> getCartlist() {
        return cartlist;
    }

    /**
     * @param cartlist the cartlist to set
     */
    public void setCartlist(Map<Integer, Items> cartlist) {
        this.cartlist = cartlist;
    }
}
