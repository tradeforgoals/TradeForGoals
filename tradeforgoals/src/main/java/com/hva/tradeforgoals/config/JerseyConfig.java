package com.hva.tradeforgoals.config;

import com.hva.tradeforgoals.api.ledenEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(ledenEndpoint.class);

    }

}
