package de.kopf3.mshack22backend.persistence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import de.kopf3.mshack22backend.persistence.document.ActivityPoint;

import java.util.List;

public interface ActivityPointRepository extends MongoRepository<ActivityPoint, ObjectId>, SpatialActivityPointRepository {


    List<ActivityPoint> findByUserId(ObjectId userId);
    List<ActivityPoint> findByTypeIn(List<String> types);
}
