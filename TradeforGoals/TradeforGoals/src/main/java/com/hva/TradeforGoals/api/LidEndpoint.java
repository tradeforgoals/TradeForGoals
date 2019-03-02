package com.hva.TradeforGoals.api;

import com.hva.TradeforGoals.entiteiten.Lid;
import com.hva.TradeforGoals.service.LedenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("lid")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LidEndpoint {

    @Autowired
    public LedenService ledenService;

    @GET
    public Response listAll(){
        Iterable<Lid> iterable = ledenService.findAll();
        return Response.ok(iterable).build();
    }

    // 1 lid ophalen op basis van ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findKandidaaat(@PathParam("id") Long id){
        Lid lid = ledenService.findById(id);
        return Response.ok(lid).build();
    }

    @POST
    public Response postKandidaat(Lid lid) {
        Lid postLid = ledenService.save(lid);
        return Response.accepted(postLid.getId()).build();
    }
}
