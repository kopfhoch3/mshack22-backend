package de.kopf3.mshack22backend.persistence.repository;

import de.kopf3.mshack22backend.persistence.document.TreePoint;
import org.bson.types.ObjectId;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpatialTreePointRepository  {

    List<TreePoint> getByRadius(Point point, double radius);
}
