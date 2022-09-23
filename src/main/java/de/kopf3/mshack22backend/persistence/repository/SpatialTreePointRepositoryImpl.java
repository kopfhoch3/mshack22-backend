package de.kopf3.mshack22backend.persistence.repository;

import de.kopf3.mshack22backend.persistence.document.TreePoint;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpatialTreePointRepositoryImpl implements SpatialTreePointRepository{
    private final MongoTemplate mongoTemplate;

    public SpatialTreePointRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<TreePoint> getByRadius(Point point, double radius){
        Query query = new Query();
        query.addCriteria(Criteria.where("location").withinSphere(new Circle(point, radius)));
        return mongoTemplate.find(query, TreePoint.class);
    }
}
