package com.yerlen.repository;

import com.yerlen.entity.Product;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.yerlen.processors.Start.ENTITY_MANAGER;

public class ProductRepository {
    public static void saveEntity(Product product) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(product);
            ENTITY_MANAGER.getTransaction().commit();
        } catch (Exception e) {
            ENTITY_MANAGER.getTransaction().rollback();
        }
    }

    public List<Product> findAll() {
        TypedQuery<Product> query = ENTITY_MANAGER.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}
