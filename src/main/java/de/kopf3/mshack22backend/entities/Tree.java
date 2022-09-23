package de.kopf3.mshack22backend.entities;

import org.hibernate.annotations.Table;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;

@Entity
public class Tree {
    private Integer id;
    private String art;
    private Point geometry;



    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public Point getGeometry() {
        return geometry;
    }

    public void setGeometry(Point geometry) {
        this.geometry = geometry;
    }
}
