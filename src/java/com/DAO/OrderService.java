///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.DAO;
//
//import com.Inteface.OrderInterface;
//import com.Model.Orders;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceUnit;
//import javax.persistence.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author Team
// */
//@Repository
//@Transactional
//public class OrderService implements OrderInterface{
//
//    /**
//     * @return the em
//     */
//    public EntityManager getEm() {
//        return em;
//    }
//
//    /**
//     * @param em the em to set
//     */
//    public void setEm(EntityManager em) {
//        this.em = em;
//    }
//    
//    @PersistenceUnit
//    EntityManagerFactory emf;
//    private EntityManager em;
//
//    @Override
//    public void saveOrder(Orders order) {
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(order);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    @Override
//    public List<Orders> showHistoryOrder(int id_user) {
//        em = emf.createEntityManager();
//        Query query = em.createQuery("select o from Orders o where o.idUser = :id_user");
//        query.setParameter("id_user", id_user);
//        List<Orders>showAllOrderforSpecificUser = query.getResultList();
//        return showAllOrderforSpecificUser;
//    }
//
//    @Override
//    public List<Orders> showAllOrders() {
//        em = emf.createEntityManager();
//        List<Orders> showAllOrders = em.createQuery("select o from Orders o").getResultList();
//        return showAllOrders;
//    }
//
//    @Override
//    public void deleteOrders(int id_user) {
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Orders o = em.find(Orders.class, id_user);
//        em.remove(o);
//        em.getTransaction().commit();
//        em.close();
//    }
//    
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Inteface.OrderInterface;
import com.Model.Orders;
import com.Model.Payment;
import com.Model.Product;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Team
 */
@Repository
@Transactional
public class OrderService implements OrderInterface {

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @PersistenceUnit
    EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void saveOrder(Orders order) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
//        em.close();
    }

    @Override
    public List<Orders> showHistoryOrder(int id_user) {
        em = emf.createEntityManager();
        Query query = em.createQuery("select o from Orders o where o.idUser = :id_user");
        query.setParameter("id_user", id_user);
        List<Orders> showAllOrderforSpecificUser = query.getResultList();
        return showAllOrderforSpecificUser;
    }

    @Override
    public List<Orders> showAllOrders() {
        em = emf.createEntityManager();
        List<Orders> showAllOrders = em.createQuery("select o from Orders o").getResultList();
        return showAllOrders;
    }

    @Override
    public void deleteOrders(int id_user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Orders o = em.find(Orders.class, id_user);
        em.remove(o);
        em.getTransaction().commit();
        em.close();
    }

    public void updateTotal(int id, double total) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Orders order = em.find(Orders.class, id);
        order.setTotal(total);
        em.merge(order);
        em.getTransaction().commit();
        em.close();
    }

    public Orders findOrderByIdUserAndOrder(int id_user, int id_order) {
        em = emf.createEntityManager();
        Query query = em.createQuery("select o from Orders o where o.idOrder=:id_order and o.idUser.idUser=:id_user");
        query.setParameter("id_order", id_order);
        query.setParameter("id_user", id_user);

        Orders order = (Orders) query.getSingleResult();
        System.out.println(order.getTotal());
        return order;
    }

    public List<Orders> showAllHistoryOrdersProduce() {
        em = emf.createEntityManager();
        List<Orders> data = em.createQuery("select o from Orders o").getResultList();
        return data;
    }
    
    public void saveDetailPayment(Payment payment){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(payment);
        em.getTransaction().commit();
        em.close();
    }
    public List<Product> detailOrder(int id){
        em = emf.createEntityManager();       
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT o from Orders o where o.idOrder =:id ");
        query.setParameter("id", id);
        List<Product> prod = query.getResultList();
        return prod;
    }
}
