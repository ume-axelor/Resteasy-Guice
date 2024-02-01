package com.example.service;

import java.util.ArrayList;
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
    
    @Override
    @Transactional
    public void updateData(int id, String name, List<Laptop> laptops) {
        em = emProvider.get();
        Student student = em.find(Student.class, (long) id);
        student.setSname(name);
        int counter = 0;
        List<Laptop> laptopList = student.getLaptops();

        for (Laptop laptop : laptops) {
            Laptop l = laptopList.get(counter);
            if (!laptop.getSerialNumber().equals(laptopList.get(counter).getSerialNumber())) {
                l.setSerialNumber(laptop.getSerialNumber());
            }
            if (!laptop.getModel().equals(laptopList.get(counter).getModel())) {
                l.setModel(laptop.getModel());
            }
            counter++;
        }
    }
    
    @Override
    @Transactional
    public void deleteData(int id) {
        em = emProvider.get();
        Student student = em.find(Student.class, (long) id);

        if (student != null) {
            List<Laptop> laptops = student.getLaptops();
            
            for (Laptop laptop : laptops) {
                em.remove(laptop);
            }
            em.remove(student);
        }
    }


    @Override
    public Student getStudent(int id) {
        em = emProvider.get();
        return em.find(Student.class, (long) id);
    }
    
    
      
}
