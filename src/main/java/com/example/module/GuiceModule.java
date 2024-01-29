package com.example.module;

import com.example.service.DataService;
import com.example.service.DataServiceImpl;
import com.example.resource.HelloRes;
import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HelloRes.class);
        bind(DataService.class).to(DataServiceImpl.class);
    }
}
