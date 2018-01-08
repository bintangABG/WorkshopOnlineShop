/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Model.Kategori;
import java.util.List;
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
public class KategoriService {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager em;

    public Kategori findById(int Id) {
        em = emf.createEntityManager();
        Kategori kategori = em.find(Kategori.class, Id);
        return kategori;
    }
    
    public List<Kategori> showAllKategori() {
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT k FROM Kategori k ");
        @SuppressWarnings("unchecked")
        List<Kategori> kategori = query.getResultList();
        return kategori;
    }
    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
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
