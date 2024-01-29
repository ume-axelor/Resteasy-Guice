package com.example.service;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DataServiceImpl implements DataService {

    private final EntityManagerFactory emf;

    @Inject
    public DataServiceImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Transactional
    @Override
    public Data createData(Data data) {
        EntityManager em = emf.createEntityManager();
        try {
            em.persist(data);
        } finally {
            em.close();
        }
		return data;
    }	
}

