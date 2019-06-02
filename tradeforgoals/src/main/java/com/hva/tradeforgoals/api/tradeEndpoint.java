package com.hva.tradeforgoals.api;

import com.hva.tradeforgoals.domain.Trade;
import com.hva.tradeforgoals.persistence.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("trades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class tradeEndpoint {

    @Autowired
    public TradeService tradeService;

    @GET
    public Response findAll(){
        Iterable<Trade> trades = tradeService.findAll();
        return Response.ok(trades).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTrade(@PathParam("id") Long id) {
        Trade trade = tradeService.findById(id);
        return Response.ok(trade).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTrade(Trade trade) {
        Trade postedTrade = tradeService.save(trade);
        return Response.accepted(postedTrade.getId()).build();
    }

}
