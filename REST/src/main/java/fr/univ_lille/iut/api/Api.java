package fr.univ_lille.iut.api;

import javax.ws.rs.ApplicationPath;

import fr.univ_lille.iut.auth.AuthFilter;
import org.glassfish.jersey.filter.LoggingFilter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/data/")
public class Api extends ResourceConfig {

    public Api() {
        packages("fr.univ_lille.iut.api");
        //register(LoggingFilter.class);
        register(AuthFilter.class);
        register(RolesAllowedDynamicFeature.class);
    }

}
