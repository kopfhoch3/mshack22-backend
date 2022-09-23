package de.kopf3.mshack22backend.persitence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import de.kopf3.mshack22backend.persitence.document.TreePoint;

public interface TreePointRepository extends MongoRepository<TreePoint, ObjectId> {
}
