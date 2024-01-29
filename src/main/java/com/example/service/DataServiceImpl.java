package com.example.service;

import com.example.model.Data;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import javax.persistence.EntityManager;

public class DataServiceImpl implements DataService {

    @Inject
    Provider<EntityManager> emProvider;

    @Transactional
    @Override
    public Data insertData(Data data) {
        EntityManager em = emProvider.get();
        try {
            em.persist(data);
        } finally {
            em.close();
        }
        return data;
    }
}
