package com.example.config;

import com.example.service.StudentLaptopService;
import com.example.service.StudentLaptopImpl;
import com.example.controller.StudentController;
import com.google.inject.AbstractModule;

public class RestServletModule extends AbstractModule {

    @Override
    protected void configure() {
    	bind(StudentController.class);
    	bind(StudentLaptopService.class).to(StudentLaptopImpl.class);
    }
}
