package com.hva.tradeforgoals.api;

import com.hva.tradeforgoals.domain.Product;
import com.hva.tradeforgoals.persistence.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class productEndpoint {

    @Autowired
    public ProductService productService;

    @GET
    public Response findAll(){
        Iterable<Product> products = productService.findAll();
        return Response.ok(products).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProduct(@PathParam("id")Long id){
        Product product = productService.findById(id);
        return Response.ok(product).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postProduct(Product product){
        Product postedProduct = productService.save(product);
        return Response.accepted(postedProduct.getId()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateProduct(@PathParam("id") Long id, Product product) {

        Product result = productService.findById(id);

        if (result == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (product.getId() != result.getId()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!(product.getTitle().equals(result.getTitle())) || !(product.getShortDescription().equals(result.getShortDescription()))){
            productService.save(product);
            return Response.ok().build();

        }else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") Long id) {

        Product product = productService.findById(id);

        if (product == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            productService.deleteById(id);
        }
        return Response.accepted().build();
    }

}
