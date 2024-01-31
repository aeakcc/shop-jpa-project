package com.yerlen.repository;

import com.yerlen.entity.ParentEntity;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.yerlen.processors.Start.ENTITY_MANAGER;
public class EntityRepository {
    public void saveEntity(ParentEntity parentEntity){
        ENTITY_MANAGER.persist(parentEntity);
    }
    public <T extends ParentEntity> List<T> findAll(Class<T> entityClass) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        TypedQuery<T> query = ENTITY_MANAGER.createQuery(jpql, entityClass);
        return query.getResultList();
    }
}
