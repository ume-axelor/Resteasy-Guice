package com.example.controller;
import com.example.model.Data;
import com.example.service.DataService;
import com.google.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertData(Map<String, String> data) {
        String field1 = data.get("field1");
        String field2 = data.get("field2");

        Data newData = new Data();
        newData.setField1(field1);
        newData.setField2(field2);

        dataService.insertData(newData);

        String response = "Data inserted successfully";
        return Response.ok().entity(response).build();
    }
}
