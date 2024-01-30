package com.example.controller;

import com.example.model.Data;
import com.example.service.DataService;
import com.google.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Map;

@Path("/hello")
public class HelloRes {

    private final DataService dataService;

    @Inject
    public HelloRes(DataService dataService) {
        this.dataService = dataService;
    }

    @POST
    @Path("/insertData")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response insertData(@FormParam("field1") String field1,
                               @FormParam("field2") String field2,
                               @Context HttpServletRequest request) {
        Data newData = new Data();
        newData.setField1(field1);
        newData.setField2(field2);

        dataService.insertData(newData);
        return Response.seeOther(URI.create("/hello/form")).build();
    }


    @GET
    @Path("/form")
    @Produces(MediaType.TEXT_HTML)
    public String getForm(Map<String, Object> model) {
        List<Data> entries = dataService.getAllEntries();
        model.put("entries", entries);

        return "/form.jsp";
    }
    

    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet() {
        return "Hello, welcome to the world of RESTful services!";
    }

    
}


