package de.kopf3.mshack22backend.persistence.repository;

import de.kopf3.mshack22backend.persistence.document.ActivityPoint;
import de.kopf3.mshack22backend.persistence.document.TreePoint;
import org.springframework.data.geo.Point;
import org.springframework.lang.Nullable;

import java.util.List;

public interface SpatialActivityPointRepository {

    List<ActivityPoint> getByRadius(Point point, double radius, List<String> types);
}
