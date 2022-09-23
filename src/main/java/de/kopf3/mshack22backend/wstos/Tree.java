package de.kopf3.mshack22backend.wstos;

import lombok.Data;
import org.springframework.data.geo.Point;

@Data
public class Tree {

    private TreeProperty properties;
    private Point geometry;

}
