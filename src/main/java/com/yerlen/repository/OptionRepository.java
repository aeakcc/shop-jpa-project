package com.yerlen.repository;

import com.yerlen.entity.Option;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.yerlen.processors.Start.ENTITY_MANAGER;

public class OptionRepository {
    public static void saveEntity(Option option) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(option);
            ENTITY_MANAGER.getTransaction().commit();
        } catch (Exception e) {
            ENTITY_MANAGER.getTransaction().rollback();
        }
    }

    public static List<Option> findAll() {
        TypedQuery<Option> query = ENTITY_MANAGER.createQuery("SELECT o FROM Option o", Option.class);
        return query.getResultList();
    }
}
