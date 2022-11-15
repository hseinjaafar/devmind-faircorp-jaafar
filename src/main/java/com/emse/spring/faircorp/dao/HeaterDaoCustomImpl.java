package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HeaterDaoCustomImpl implements HeaterDaoCustom{
    @PersistenceContext
    private EntityManager em;
    @Override
    public int deleteByRoom(Long id){
        String jpql = ("delete from Heater h where h.room.id = :id");
        return em.createQuery(jpql)
                .setParameter("id",id)
                .executeUpdate();
    }

}
