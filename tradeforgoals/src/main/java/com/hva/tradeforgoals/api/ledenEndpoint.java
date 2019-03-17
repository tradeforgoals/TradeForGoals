package com.hva.tradeforgoals.api;


import com.hva.tradeforgoals.domain.Lid;
import com.hva.tradeforgoals.persistence.LedenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("lid")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ledenEndpoint {

    @Autowired
    public LedenService ledenService;

    @GET
    public Response listAll() {
        Iterable<Lid> iterable = ledenService.findAll();
        return Response.ok(iterable).build();
    }

    // 1 lid ophalen op basis van ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKandidaaat(@PathParam("id") Long id) {
        Lid lid = ledenService.findById(id);
        return Response.ok(lid).build();
    }

    @POST
    public Response postKandidaat(Lid lid) {
        Lid postLid = ledenService.save(lid);
        return Response.accepted(postLid.getId()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateLid(@PathParam("id") Long id, Lid lid) {
        Lid result = ledenService.findById(id);
        Boolean change = true;
        if (lid == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (lid.getId() != result.getId()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (change) {
            ledenService.save(lid);
            return Response.ok().build();
        } else return Response.notModified().build();

    }
}
