package de.kopf3.mshack22backend.entities;

import javax.persistence.*;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "POINTS")
public class ActivityPoint {
    @Id
    private Long id;

    private Point coordinates;
    
    @Column(
        name = "TITLE", 
        length = 50
    )
    private String title;

    private String description;
    private String type;
    private ZonedDateTime timeStamp;
    
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    
    private boolean resolved;
}
