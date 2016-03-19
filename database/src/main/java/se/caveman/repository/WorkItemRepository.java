package se.caveman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.caveman.model.jpa.JpaWorkItem;

@Repository
public interface WorkItemRepository extends CrudRepository<JpaWorkItem, Long> {
}
