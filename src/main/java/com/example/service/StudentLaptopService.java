package com.example.service;

import java.util.List;

import com.example.model.Student;
import com.example.model.Laptop;

public interface StudentLaptopService {

   public void addData(String name, List<Laptop> laptops);
   
   public void updateData(int id, String name, List<Laptop> laptops);

   public List<Student> getAllData();

   public void deleteData(int id);
   
   public Student getStudent(int id); 
    
}
