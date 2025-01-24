package org.testProject;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")

public class GreetingResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String hello() {
        // Test DB interaction
        MyEntity entity = new MyEntity();
        entity.field = "Hello from DB";
        em.persist(entity);

        return "Entity saved with ID: " + entity.id;
    }
}