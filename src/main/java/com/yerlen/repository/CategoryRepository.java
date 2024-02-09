package com.yerlen.repository;

import com.yerlen.entity.Category;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.yerlen.processors.Start.ENTITY_MANAGER;

public class CategoryRepository {
    public static void saveEntity(Category category){
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(category);
            ENTITY_MANAGER.getTransaction().commit();
        }
        catch (Exception e){
            ENTITY_MANAGER.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public static List<Category> findAll() {
        TypedQuery<Category> query = ENTITY_MANAGER.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }
}
