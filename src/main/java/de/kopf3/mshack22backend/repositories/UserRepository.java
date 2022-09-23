package de.kopf3.mshack22backend.repositories;

import de.kopf3.mshack22backend.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
