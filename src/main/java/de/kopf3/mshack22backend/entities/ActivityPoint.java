package de.kopf3.mshack22backend.entities;

import com.vividsolutions.jts.geom.Point;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "POINTS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public class ActivityPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
