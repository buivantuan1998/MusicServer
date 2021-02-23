package com.xtel.core.sys.controller;

import com.xtel.core.sys.dto.request.customer.LoginRequest;
import com.xtel.core.sys.service.customer.CustomerService;
import com.xtel.core.sys.service.customer.impl.CustomerServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerServiceImpl();
    }

    @POST
    @Path("/login")
    public Response loginCustomer(LoginRequest loginRequest) {
        return Response.ok(customerService.login(loginRequest)).build();
    }
}
