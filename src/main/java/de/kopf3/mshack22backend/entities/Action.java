package de.kopf3.mshack22backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "ACTIONS")
public class Action {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "POINT_ID")
    private ActivityPoint point;
    
    private String type;
    private ZonedDateTime timestamp;
    private String message;
}
