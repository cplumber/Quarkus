package org.testProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Schema(description = "Represents a simple entity with fields")
@Entity
public class MyEntity {

    @Id
    @GeneratedValue
    @Schema(description = "Unique identifier of the entity (auto-generated, do not include in requests)", example = "1", readOnly = true)
    public Long id;

    @Schema(description = "The main field of the entity", example = "example value", required = true)
    public String field;

    @Schema(description = "An additional field for extended information", example = "additional example", required = false)
    public String additionalField;
}