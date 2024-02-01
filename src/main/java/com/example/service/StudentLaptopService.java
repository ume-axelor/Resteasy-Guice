package com.example.service;

import java.util.List;

import com.example.model.Student;
import com.example.model.Laptop;

public interface StudentLaptopService {

   void addData(String name, List<Laptop> laptops);
   
   void updateData(int id, String name, List<Laptop> laptops);

   List<Student> getAllData();

   void deleteData(int id);
   
   Student getStudent(int id);
    
}
