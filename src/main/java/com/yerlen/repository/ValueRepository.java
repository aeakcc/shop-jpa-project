package com.yerlen.repository;

import com.yerlen.entity.Value;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.yerlen.processors.Start.ENTITY_MANAGER;

public class ValueRepository {
    public static void saveEntity(Value value){
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(value);
            ENTITY_MANAGER.getTransaction().commit();
        }catch (Exception e){
            ENTITY_MANAGER.getTransaction().rollback();
        }
    }
    public List<Value> findAll() {
        TypedQuery<Value> query = ENTITY_MANAGER.createQuery("SELECT v FROM Value v", Value.class);
        return query.getResultList();
    }
}
