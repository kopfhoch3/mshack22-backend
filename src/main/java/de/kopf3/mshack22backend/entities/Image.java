package de.kopf3.mshack22backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "IMAGES")
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    
    @ManyToOne
    @JoinColumn(name = "POINT_ID")
    private ActivityPoint point;
    
    private boolean isPrimary;
}
