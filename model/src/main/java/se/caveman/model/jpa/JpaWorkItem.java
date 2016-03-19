package se.caveman.model.jpa;

import javax.persistence.Entity;

@Entity
public class JpaWorkItem extends AbstractEntity {

    private final String description;

    public JpaWorkItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
