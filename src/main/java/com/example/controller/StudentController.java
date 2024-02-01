package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import com.google.inject.Inject;
import com.example.model.Student;
import com.example.model.Laptop;
import com.example.service.StudentLaptopService;

@Path("/")
public class StudentController {

    @Inject
    StudentLaptopService studentLaptopService;

    @GET
    @Path("/get")
    public void showData(@Context HttpServletRequest request, @Context HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = studentLaptopService.getAllData();
        request.setAttribute("list", students);
        request.getRequestDispatcher("/insert.jsp").forward(request, response);
    }

    @Path("/add")
    @POST
    public void insert(@FormParam("sname") String name, @FormParam("brand") String[] brands,
            @FormParam("model") String[] models, @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws ServletException, IOException {

        List<Laptop> laptops = new ArrayList<>();
        for (int i = 0; i < brands.length; i++) {
            Laptop laptop = new Laptop();
            laptop.setBrand(brands[i]);
            laptop.setModel(models[i]);
            laptops.add(laptop);
        }
        studentLaptopService.addData(name, laptops);
        response.sendRedirect(request.getContextPath());
    }
    
    @Path("/delete")
    @GET
    public void deleteStudent(@QueryParam("id") int id, @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws ServletException, IOException {
        studentLaptopService.deleteData(id);
        response.sendRedirect(request.getContextPath());
    }

    @Path("/edit")
    @GET
    public void editStudent(@QueryParam("id") int id, @Context HttpServletRequest request,
            @Context HttpServletResponse response) throws ServletException, IOException {
        Student studentDetail = studentLaptopService.getStudent(id);
        request.setAttribute("studentDetail", studentDetail);
        request.getRequestDispatcher("/insert.jsp").forward(request, response);
    }

    @Path("/update")
    @POST
    public void updateStudent(@QueryParam("id") int id, @FormParam("sname") String name,
            @FormParam("brand") String[] brands, @FormParam("model") String[] models,
            @Context HttpServletRequest request, @Context HttpServletResponse response)
            throws ServletException, IOException {

        List<Laptop> laptops = new ArrayList<>();
        for (int i = 0; i < brands.length; i++) {
            Laptop laptop = new Laptop();
            laptop.setBrand(brands[i]);
            laptop.setModel(models[i]);
            laptops.add(laptop);
        }
        studentLaptopService.updateData(id, name, laptops);
        response.sendRedirect(request.getContextPath() + "/get");
    }

}