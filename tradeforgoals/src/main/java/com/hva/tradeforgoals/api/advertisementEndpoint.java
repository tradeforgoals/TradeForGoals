package com.hva.tradeforgoals.api;

import com.hva.tradeforgoals.domain.Advertisement;
import com.hva.tradeforgoals.persistence.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("advertisement")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class advertisementEndpoint {

    @Autowired
    public AdvertisementService advertisementService;

    @GET
    public Response findAll(){
        Iterable<Advertisement> advertisements = advertisementService.findAll();
        return Response.ok(advertisements).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAdvertisement(@PathParam("id")Long id){
        Advertisement advertisement = advertisementService.findById(id);
        return Response.ok(advertisement).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postAdvertisement(Advertisement advertisement){
        Advertisement postedAdvertisement = advertisementService.save(advertisement);
        return Response.accepted(postedAdvertisement.getId()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateLid(@PathParam("id") Long id, Advertisement advertisement){

        Advertisement result = advertisementService.findById(id);

        if (advertisement == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (advertisement.getId() != result.getId()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (!(advertisement.getTitle().equals(result.getTitle())) || !(advertisement.getDescription().equals(result.getDescription()))){
            advertisementService.save(advertisement);
            return Response.ok().build();

        }else {
            return Response.notModified().build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteLid(@PathParam("id") Long id){

        Advertisement advertisement = advertisementService.findById(id);

        if (advertisement == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            advertisementService.deleteById(id);
        }
        return Response.accepted().build();
    }

}