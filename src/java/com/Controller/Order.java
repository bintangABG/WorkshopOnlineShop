///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.Controller;
//
//import com.Bean.CartBean;
//import com.DAO.ItemService;
//import com.DAO.OrderService;
//import com.DAO.ProductService;
//import com.Model.Items;
//import com.Model.Orders;
//import com.Model.User;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author Team
// */
//@Controller
//@RequestMapping("/order")
//public class Order {
//
//    @Autowired
//    OrderService os;
//    @Autowired
//    ProductService ps;
//    @Autowired
//    ItemService iss;
//
//    @RequestMapping()
//    public String saveItems(HttpSession session, ModelMap model) {
//         CartBean carts = (CartBean) session.getAttribute("cart");
//        double discount=0.0;
//        double hargadiscount=0.0;
//        Items items=new Items();
//        List<Items> itm = new ArrayList<>();
//        for (Map.Entry<Integer, Items> entry : carts.getCartlist().entrySet()) {
//            Integer key = entry.getKey();
//            Object value = entry.getValue();
//            itm.add(iss.findItemsById(entry.getValue().getIdItems()));
//            items.setIdProduct(entry.getValue().getIdProduct());
//            items.setQtyBeli(entry.getValue().getQtyBeli());
//            if(entry.getValue().getQtyBeli()>3){
//                discount+=0.05;
//                hargadiscount=(entry.getValue().getQtyBeli()* entry.getValue().getIdProduct().getHarga()*discount);
//            }
//            if(entry.getValue().getQtyBeli()<3){
//                hargadiscount=(entry.getValue().getQtyBeli()* entry.getValue().getIdProduct().getHarga()*discount);
//           
//            }
//            items.setSubTotal(entry.getValue().getQtyBeli()*entry.getValue().getIdProduct().getHarga()-hargadiscount);
//        }
//        
//        User user=(User) session.getAttribute("user");
//        items.setCreatedby(user.getIdUser());
//        items.setDiscount(discount);
//        items.setUpdatedby(user.getIdUser());
//        items.setCreateddate(new Date());
//        items.setUpdateddate(new Date());
//        
//        iss.saveOrderDet(items);
//        
//        return "redirect:/pembayaran";
//    }
//    
//    
//     @RequestMapping(value = "/saveord")
//    public String saveOrder(HttpSession session,ModelMap model){
//        CartBean cart=(CartBean) session.getAttribute("cart");
//        Orders order=new Orders();
//        User user=(User) session.getAttribute("user");
//        order.setIdUser(user);
//        return "/welcome";
//    }
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Controller;

import com.Bean.CartBean;
import com.Bean.PaymentBean;
import com.DAO.ItemService;
import com.DAO.OrderService;
import com.DAO.ProductService;
import com.DTO.OrderDTO;
import com.Model.Items;
import com.Model.Orders;
import com.Model.Payment;
import com.Model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Team
 */
@Controller
@RequestMapping("/order")
public class Order {

    @Autowired
    OrderService os;
    @Autowired
    ProductService ps;
    @Autowired
    ItemService iss;

//    @RequestMapping(value = "/addOrder")
//    public String saveItems(HttpSession session, ModelMap model) {
//         CartBean carts = (CartBean) session.getAttribute("cart");
//        double discount=0.0;
//        double hargadiscount=0.0;
//        Items items=new Items();
//        List<Items> itm = new ArrayList<>();
//        for (Map.Entry<Integer, Items> entry : carts.getCartlist().entrySet()) {
//            Integer key = entry.getKey();
//            Object value = entry.getValue();
//            itm.add(iss.findItemsById(entry.getValue().getIdItems()));
//            items.setIdProduct(entry.getValue().getIdProduct());
//            items.setQtyBeli(entry.getValue().getQtyBeli());
//            if(entry.getValue().getQtyBeli()>3){
//                discount+=0.05;
//                hargadiscount=(entry.getValue().getQtyBeli()* entry.getValue().getIdProduct().getHarga()*discount);
//            }
//            if(entry.getValue().getQtyBeli()<3){
//                hargadiscount=(entry.getValue().getQtyBeli()* entry.getValue().getIdProduct().getHarga()*discount);
//           
//            }
//            items.setSubTotal(entry.getValue().getQtyBeli()*entry.getValue().getIdProduct().getHarga()-hargadiscount);
//        }
//        
//        User user=(User) session.getAttribute("user");
//        items.setCreatedby(user.getIdUser());
//        items.setDiscount(discount);
//        items.setUpdatedby(user.getIdUser());
//        items.setCreateddate(new Date());
//        items.setUpdateddate(new Date());
//        
//        iss.saveOrderDet(items);
//        
//        return "redirect:/pembayaran";
//    }
//    
//    
//     @RequestMapping(value = "/saveord")
//    public String saveOrder(HttpSession session,ModelMap model){
//        CartBean cart=(CartBean) session.getAttribute("cart");
//        Orders order=new Orders();
//        User user=(User) session.getAttribute("user");
//        order.setIdUser(user);
//        return "/welcome";
//    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveItems(HttpSession session, ModelMap model, @ModelAttribute("paymentbean") PaymentBean paymentbean) {

        CartBean carts = (CartBean) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Double total = 0.0;

        for (Map.Entry<Integer, Items> entry : carts.getCartlist().entrySet()) {
            total += entry.getValue().getSubTotal();
        }
        Orders order = new Orders();
        Items itmz = new Items();

        double discount = 0.0;
        double hargadiscount = 0.0;
        double ppn = 0.1;
//        double total = 0.0;

        order.setIdUser(user);
        order.setPpn(ppn);
        order.setCreatedby(user.getIdUser());
        order.setUpdatedby(user.getIdUser());
        order.setCreateddate(new Date());
        order.setUpdateddate(new Date());
        order.setIsCredit(paymentbean.getCredit());
        order.setTotal(total);
        os.saveOrder(order);
        List<Items> barangYgDibeli = new ArrayList<>();
        for (Map.Entry<Integer, Items> entry : carts.getCartlist().entrySet()) {
            barangYgDibeli.add(entry.getValue());

            if (entry.getValue().getQtyBeli() > 3) {
                discount += 0.05;
                hargadiscount = (entry.getValue().getQtyBeli() * entry.getValue().getIdProduct().getHarga() * discount);
            }
            if (entry.getValue().getQtyBeli() < 3) {
                hargadiscount = (entry.getValue().getQtyBeli() * entry.getValue().getIdProduct().getHarga() * discount);

            }

            entry.getValue().setSubTotal(entry.getValue().getQtyBeli() * entry.getValue().getIdProduct().getHarga() - hargadiscount);
            total += itmz.getSubTotal();
            entry.getValue().setIdOrder(order);
            entry.getValue().setCreatedby(user.getIdUser());
            entry.getValue().setCreateddate(new Date());
            entry.getValue().setUpdatedby(user.getIdUser());
            entry.getValue().setUpdateddate(new Date());
            iss.saveOrderDet(entry.getValue());
        }
        //os.updateTotal(order.getIdOrder(), (total * ppn) + total);

//        Items items = new Items();
//        List<Items> itm = new ArrayList<>();
//        for (Map.Entry<Integer, Items> entry : carts.getCartlist().entrySet()) {
//            Integer key = entry.getKey();
//            Object value = entry.getValue();
//            int idItems = entry.getValue().getIdItems();
//            itm.add(iss.findItemsById(idItems));
//            items.setIdProduct(entry.getValue().getIdProduct());
//            items.setQtyBeli(entry.getValue().getQtyBeli());
//            if (entry.getValue().getQtyBeli() > 3) {
//                discount += 0.05;
//                hargadiscount = (entry.getValue().getQtyBeli() * entry.getValue().getIdProduct().getHarga() * discount);
//            }
//            if (entry.getValue().getQtyBeli() < 3) {
//                hargadiscount = (entry.getValue().getQtyBeli() * entry.getValue().getIdProduct().getHarga() * discount);
//
//            }
//            items.setSubTotal(entry.getValue().getQtyBeli() * entry.getValue().getIdProduct().getHarga() - hargadiscount);
//            total += items.getSubTotal();
//        }
//
//        //User user=(User) session.getAttribute("user");
//        System.out.println("user : " + user.getNama());
//        items.setCreatedby(user.getIdUser());
//        items.setDiscount(discount);
//        items.setUpdatedby(user.getIdUser());
//        items.setCreateddate(new Date());
//        items.setUpdateddate(new Date());
        //order.setTotal((total * ppn) + total);
        //order.setIdItems(items);
//        iss.saveOrderDet(items);
        Payment payment = new Payment();
        char as = 0;
        double uang_muka = 0.0;
        if (paymentbean.getIsAsuransi() == 0) {
            as = 'Y';
            uang_muka = paymentbean.getUang_muka();
        }
        if (paymentbean.getIsAsuransi() == 1) {
            as = 'T';
            
        }

        
       
        
        payment.setAsuransiPengiriman(as);
        payment.setIdOrder(order);
        payment.setJenisPengiriman(paymentbean.getJenis_paket());
        payment.setTujuanPengiriman(paymentbean.getKota_tujuan());
        payment.setGajiPokok(0);
        payment.setTanggungan(0);
        payment.setPenghasilanTambahan(0);
        payment.setUangMuka(0);

        os.saveDetailPayment(payment);
        session.setAttribute("order", order);
        
        //produce data ke credit
        RestTemplate rest = new RestTemplate();
        //String url = "192.168.3.192:8084/PaymentAndCredit/api/customer.jsp";
        OrderDTO lemparOrder = new OrderDTO();
        lemparOrder.setPembeli(order.getIdUser().getNama());
        lemparOrder.setAlamat(order.getIdUser().getAlamat());
        lemparOrder.setIsCredit(order.getIsCredit());
        lemparOrder.setJenis_kelamin(order.getIdUser().getJenisKelamin());
        lemparOrder.setTelp(order.getIdUser().getTelp());
        lemparOrder.setGaji_pokok(0);
        lemparOrder.setPenghasilan_tambahan(0);
        lemparOrder.setTanggungan(0);
        lemparOrder.setUang_muka(0);
        
        //OrderDTO kirimData = rest.postForObject(url, rest, OrderDTO.class);
        
        session.removeAttribute("cart");
        return "redirect:/index";
    }

}
