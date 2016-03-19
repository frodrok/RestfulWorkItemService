package se.caveman.model.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    protected AbstractEntity() {

    }

    public Long getId() {
        return id;
    }
}
