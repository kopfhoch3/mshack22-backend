package de.kopf3.mshack22backend.persistence.repository;

import de.kopf3.mshack22backend.persistence.document.ActivityPoint;
import de.kopf3.mshack22backend.persistence.document.TreePoint;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpatialActivityPointRepositoryImpl implements SpatialActivityPointRepository{
    private final MongoTemplate mongoTemplate;

    public SpatialActivityPointRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<ActivityPoint> getByRadius(Point point, double radius, List<String> types){
        Query query = new Query();
        query.addCriteria(Criteria.where("location").withinSphere(new Circle(point, radius)));
        query.addCriteria(Criteria.where("type").in(types));

        return mongoTemplate.find(query, ActivityPoint.class);
    }
}
