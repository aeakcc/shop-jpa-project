package com.yerlen.processors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Start {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("main");
    public static final EntityManager ENTITY_MANAGER = FACTORY.createEntityManager();

    public static void main(String[] args) {
        AllProcesses.startProcess();
    }
}
