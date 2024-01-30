package com.example.service;

import com.example.model.Data;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DataServiceImpl implements DataService {

    @Inject
    Provider<EntityManager> emProvider;

    @Transactional
    @Override
    public void insertData(Data data) {
        EntityManager em = emProvider.get();
        try {
            em.persist(data);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Data> getAllEntries() {
        EntityManager em = emProvider.get();
        try {
            TypedQuery<Data> query = em.createQuery("SELECT d FROM Data d", Data.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
