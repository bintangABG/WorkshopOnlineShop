/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import com.Inteface.UserInteface;
import com.Model.Orders;
import com.Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserService implements UserInteface{
    
    static final Logger logger = Logger.getLogger(UserService.class.getName());
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;

    @Override
    public void saveUser(User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<User> showAllUser() {
       em = emf.createEntityManager();
       List<User> allUser = em.createQuery("select u from User u Where u.level = '2' ").getResultList();
       return allUser;
    }

    @Override
    public User findUserById(int id) {
        em = emf.createEntityManager();
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public User findUserByName(String name) {
        em = emf.createEntityManager();
        Query  q = em.createQuery("select u from User u where u.username = :name");
        q.setParameter("name", name);
        User user = (User) q.getSingleResult();
        return user;
    }

    @Override
    public void deleteUser(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class,id);
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void editUser(int id,User user) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        User users = em.find(User.class, id);
        users.setAlamat(user.getAlamat());
        users.setEmail(user.getEmail());
        users.setImage(user.getImage());
        users.setJenisKelamin(user.getJenisKelamin());
        users.setNama(user.getNama());
        users.setPassword(user.getPassword());
        users.setTelp(user.getTelp());
        users.setUsername(user.getUsername());
        em.merge(users);
        em.getTransaction().commit();
    }
    
    public List<Orders> historyUser(int id){
        em = emf.createEntityManager();       
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT o FROM Orders o WHERE o.idUser.idUser =:id");
        query.setParameter("id", id);
        List<Orders> od = query.getResultList();
        return od;
    }
    
}
