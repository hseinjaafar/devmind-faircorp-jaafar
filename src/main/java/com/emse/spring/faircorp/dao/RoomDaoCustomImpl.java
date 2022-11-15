package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findAllWindowsByRoomName(String name){
        String jpql = "select w from Window w where w.room.name = :name";
        return em.createQuery(jpql, Window.class)
                .setParameter("name", name)
                .getResultList();
    }
    @Override
    public int deleteRoomByBuildingId(Long id){
        String jpql = ("delete from Room r where r.building.id = :id");
        return em.createQuery(jpql)
                .setParameter("id",id)
                .executeUpdate();
    }

}
