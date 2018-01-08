/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import com.Bean.CartBean;
import com.DAO.ProductService;
import com.Model.Items;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Team
 */
@Controller
@RequestMapping("/cart")
public class Cart {

    @Autowired
    ProductService ps;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/orderproduct/{id}", method = RequestMethod.GET)
    public String orderProduct(@PathVariable Integer id, ModelMap katalogProduct, HttpSession session) {
//        int qty_beli = isExistingSessionCart(session);
        if (session.getAttribute("cart") == null) {
            CartBean cart = new CartBean();
            cart.getCartlist().put(id, new Items(1, 0, ps.findProductById(id).getHarga() * 1, ps.findProductById(id)));
            session.setAttribute("cart", cart);
        } else {
            CartBean cart = (CartBean) session.getAttribute("cart");
            //cek udah ada atau engga dikeranjang buat update quantity nya
            int ada = isExisting(id, session);
            if (ada == -1) {
                cart.getCartlist().put(id, new Items(1, 0, ps.findProductById(id).getHarga() * 1, ps.findProductById(id)));

            } else {
                int quantity = cart.getCartlist().get(id).getQtyBeli() + 1;
                double disc = 0.0;
                if (quantity > 1 && quantity < 5) {
                    disc += 0.5;
                }
                if (quantity > 5) {
                    disc += 1;
                }
                int subtotal = (int) (ps.findProductById(id).getHarga() * quantity * disc);
                cart.getCartlist().put(id, new Items(quantity, disc, ps.findProductById(id).getHarga() * quantity * disc, ps.findProductById(id)));

            }
            session.setAttribute("cart", cart);

        }

        return "redirect:/product/allproduct";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteItemsCart(@PathVariable(value = "id") int id, HttpSession session) {
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart.getCartlist().get(id).getQtyBeli() != 0) {
            int qtylama = cart.getCartlist().get(id).getQtyBeli();
            double disc = 0.0;
            if (qtylama > 1 && qtylama < 5) {
                disc += 0.5;
            }
            if (qtylama > 5) {
                disc += 1;
            }
            cart.getCartlist().put(id, new Items(qtylama - 1, disc, qtylama, ps.findProductById(id)));
        }
        
        if(cart.getCartlist().get(id).getQtyBeli()==0){
            cart.getCartlist().remove(id);
        }

        session.setAttribute("cart", cart);
        return "redirect:/welcome";
    }

    @SuppressWarnings("unchecked")
    private int isExisting(int id, HttpSession session) {

        CartBean cart = (CartBean) session.getAttribute("cart");

        if (cart != null) {
            if (cart.getCartlist().get(id) != null) {
                return cart.getCartlist().get(id).getQtyBeli();
            }
        }

        return -1;

    }

    //cek udah ada belum dari session beli
    @SuppressWarnings("unchecked")
    private int isExistingSessionCart(HttpSession session) {

        CartBean cart = (CartBean) session.getAttribute("cart");

        if (cart == null) {
            return 1;
        }

        return -1;

    }
}
