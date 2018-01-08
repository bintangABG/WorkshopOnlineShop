/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Model.Items;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Team
 */
@Repository
@Transactional
public class ItemService {

    @PersistenceUnit
    EntityManagerFactory emf;
    private EntityManager em;
    
    public void saveOrderDet(Items items) {
       em = emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(items);
       em.getTransaction().commit();
       em.close();
    }

    public Items findItemsById(Integer idItems) {
        em = emf.createEntityManager();
        Items item = em.find(Items.class, idItems);
        return item;
    }

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
    
}
