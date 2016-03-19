package se.caveman.repository;

import org.springframework.data.repository.CrudRepository;
import se.caveman.model.jpa.JpaUser;

public interface UserRepository extends CrudRepository<JpaUser, Long> {
}
