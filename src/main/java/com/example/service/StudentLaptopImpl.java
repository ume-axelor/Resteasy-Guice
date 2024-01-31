package com.example.service;

import java.util.List;
import javax.persistence.EntityManager;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import com.example.model.Student;
import com.example.model.Laptop;

public class StudentLaptopImpl implements StudentLaptopService {

    @Inject
    Provider<EntityManager> emProvider;

    EntityManager em;

    @Override
    @Transactional
    public void addData(String name, List<Laptop> laptops) {
        em = emProvider.get();
        Student student = new Student();
        student.setSname(name);
        student.setLaptops(laptops);
        em.persist(student);
        for (Laptop laptop : laptops) {
            laptop.setStudent(student);
            em.persist(laptop);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllData() {
        em = emProvider.get();
        List<Student> students = em.createQuery("select s from Student s").getResultList();
        return students;
    }
    
}
