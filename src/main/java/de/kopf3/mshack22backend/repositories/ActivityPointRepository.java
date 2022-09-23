package de.kopf3.mshack22backend.repositories;

import de.kopf3.mshack22backend.entities.ActivityPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityPointRepository extends CrudRepository<ActivityPoint, Long> {
}
