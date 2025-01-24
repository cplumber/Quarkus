package org.testProject;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Path("/my-entity")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyEntityResource {

    @Inject
    EntityManager em;

    // Create a new entity
    @POST
    @Transactional
    public MyEntity createEntity(@NotNull MyEntity entity) {
        if (entity.id != null) {
            throw new WebApplicationException("ID should not be provided for a new entity. It is auto-generated.", 400);
        }
        em.persist(entity);
        return entity;
    }
 
    // Retrieve all entities using raw SQL
    @GET
    @Path("/raw-sql")
    @SuppressWarnings("unchecked")
    public List<MyEntity> getAllEntitiesRawSql() {
        String sql = "SELECT id, field, additionalfield FROM myentity";
        return em.createNativeQuery(sql, MyEntity.class).getResultList();
    }

    // Retrieve all entities
    @GET
    public List<MyEntity> getAllEntities() {
        return em.createQuery("FROM MyEntity", MyEntity.class).getResultList();
    }

    // Retrieve a single entity by ID
    @GET
    @Path("/{id}")
    public MyEntity getEntityById(@PathParam("id") Long id) {
        return em.find(MyEntity.class, id);
    }

    // Update an entity by ID
    @PUT
    @Path("/{id}")
    @Transactional
    public MyEntity updateEntity(@PathParam("id") Long id, MyEntity updatedEntity) {
        MyEntity entity = em.find(MyEntity.class, id);
        if (entity == null) {
            throw new WebApplicationException("Entity with ID " + id + " not found", 404);
        }
        entity.field = updatedEntity.field;
        entity.additionalField = updatedEntity.additionalField;
        return entity;
    }

    // Delete an entity by ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteEntity(@PathParam("id") Long id) {
        MyEntity entity = em.find(MyEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        } else {
            throw new WebApplicationException("Entity with ID " + id + " not found", 404);
        }
    }
}
