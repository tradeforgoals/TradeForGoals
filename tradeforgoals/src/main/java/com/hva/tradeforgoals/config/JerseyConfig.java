package com.hva.tradeforgoals.config;

import com.hva.tradeforgoals.api.advertisementEndpoint;
import com.hva.tradeforgoals.api.ledenEndpoint;
import com.hva.tradeforgoals.api.productEndpoint;
import com.hva.tradeforgoals.api.tradeEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(ledenEndpoint.class);
        register(advertisementEndpoint.class);
        register(productEndpoint.class);
        register(tradeEndpoint.class);

    }

}
