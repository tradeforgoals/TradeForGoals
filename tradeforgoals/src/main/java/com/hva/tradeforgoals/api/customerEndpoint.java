package com.hva.tradeforgoals.api;

import com.hva.tradeforgoals.domain.Customer;
import com.hva.tradeforgoals.domain.EmptyResponse;
import com.hva.tradeforgoals.persistence.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class customerEndpoint {

    @Autowired
    public CustomerService customerService;

    @GET
    public Response listAll() {
        Iterable<Customer> iterable = customerService.findAll();
        return Response.ok(iterable).build();
    }

    // 1 lid ophalen op basis van ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCustomer(@PathParam("id") String id) {
        Customer customer = customerService.findById(id);

        if (customer == null) {
            return Response.ok(new EmptyResponse()).build();
        }
        return Response.ok(customer).build();
    }

    @GET
    @Path("{id}/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCustomerProducts(@PathParam("id") String id) {
        Customer customer = customerService.findById(id);
        return Response.ok(customer).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response postCustomer(Customer customer) {
        Customer postCustomer = customerService.save(customer);
        return Response.accepted(postCustomer.getId()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCustomer(@PathParam("id") String id, Customer customer) {
        Customer result = customerService.findById(id);

        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (!(customer.getId().equals(result.getId()))) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (!(customer.equals(result))) {

            customerService.save(customer);
            return Response.ok().build();
        }
        else{
            return Response.notModified().build();
        }

    }

    @DELETE
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") String id) {

        Customer customer = customerService.findById(id);

        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            customerService.deleteById(id);
        }
        return Response.accepted().build();
    }
}
