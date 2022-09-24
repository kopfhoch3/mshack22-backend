package de.kopf3.mshack22backend.persistence.document;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreePoint {
    @MongoId
    private ObjectId id;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;
    private String title;
    private String description;
    private Date timestamp;
    private boolean resolved;
    private String treeFamily;
    private List<Image> images;
    private List<Action> actions;
    private List<GießAction> gießActions;
}
