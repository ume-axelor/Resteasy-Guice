package com.example.resource;

import com.example.service.Data;
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
    public Response insertData(Map<String, Object> data) {
        String field1 = (String) data.get("field1");
        String field2 = (String) data.get("field2");

        Data newData = new Data();
        newData.setField1(field1);
        newData.setField2(field2);

        dataService.createData(newData);

        String response = "Data inserted successfully";
        return Response.ok().entity(response).build();
    }
}
