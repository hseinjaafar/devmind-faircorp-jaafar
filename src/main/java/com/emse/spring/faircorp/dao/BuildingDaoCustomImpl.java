package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> findAllHeatersInBuilding(Long id){
        String jpql = "select h FROM Heater h where h.room.id in (select r.id FROM Room r where r.building.id = :id)";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Window> findAllWindowsInBuilding(Long id){
        String jpql = "select w FROM Window w where w.room.id in (select r.id FROM Room r where r.building.id = :id)";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }



}
