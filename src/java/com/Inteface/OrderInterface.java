/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Inteface;

import com.Model.Orders;
import java.util.List;

/**
 *
 * @author rudy
 */


//Inteface DAO
public interface OrderInterface {
    public void saveOrder(Orders order); //method buat simpan
    public List<Orders> showHistoryOrder(int id_user);
    public List<Orders> showAllOrders();
    public void deleteOrders(int id_user);
}
