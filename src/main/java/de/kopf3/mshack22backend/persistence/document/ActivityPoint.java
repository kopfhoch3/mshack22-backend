package de.kopf3.mshack22backend.persistence.document;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.bson.types.ObjectId;
import org.springframework.data.geo.Point;
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
public class ActivityPoint {
    @MongoId
    @JsonIgnore
    private ObjectId id;


    @JsonSetter("id")
    public void setId(String id){
        this.id = new ObjectId(id);
    }
    @JsonGetter("id")
    public String getId(){
        return this.id==null?null:this.id.toHexString();
    }

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonIgnore
    private GeoJsonPoint location;

    @JsonSetter("location")
    public void setLocation(Point point){
        this.location = new GeoJsonPoint(point.getX(), point.getY());
    }
    @JsonGetter("location")
    public Point getLocation(){
        return this.location==null?null:new Point(this.location.getX(), this.location.getY());
    }
    private String title;
    private String description;
    private Date timestamp;
    private boolean resolved;
    private List<Action> actions;
    private List<Image> images;
    private String type;

    @JsonIgnore
    private ObjectId userId;

    @JsonSetter("userId")
    public void setUserId(String id){
        this.userId = new ObjectId(id);
    }
    @JsonGetter("userId")
    public String getUserId(){
        return this.userId==null?null:this.userId.toHexString();
    }
}
