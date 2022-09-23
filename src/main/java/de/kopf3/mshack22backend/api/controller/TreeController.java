package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.persistence.document.ActivityPoint;
import de.kopf3.mshack22backend.persistence.document.TreePoint;
import de.kopf3.mshack22backend.persistence.document.User;
import de.kopf3.mshack22backend.persistence.repository.TreePointRepository;
import de.kopf3.mshack22backend.wstos.Tree;
import de.kopf3.mshack22backend.wstos.TreeWrapper;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TreeController {

    private final TreePointRepository treePointRepository;

    @PostMapping("treeimport")
    public List<TreePoint> importGeoJson(@RequestBody TreeWrapper treeWrapper) {
        final var treeDocuments = treeWrapper.getFeatures().stream()
            .map(this::createTreePoint)
            .toList();
        return this.treePointRepository.saveAll(treeDocuments);
    }

    private TreePoint createTreePoint(final Tree tree) {
        final TreePoint tp = new TreePoint();
        tp.setTitle("Baum");
        tp.setDescription("Baum");
        tp.setTreeFamily(tree.getProperties().getBaumgruppe());
        tp.setResolved(false);
        tp.setLocation(new GeoJsonPoint(tree.getGeometry().getX(), tree.getGeometry().getY()));
        tp.setTimestamp(Timestamp.from(ZonedDateTime.now().toInstant()));
        return tp;

    }

    /**
     *
     * @param radius in m
     * @return list of points in radius
     */
    @GetMapping()
    public List<TreePoint> getByLocationAndRadius(double x, double y, int radius){
        return treePointRepository.getByRadius(new Point(x, y), 1d/6370000 * radius);
    }


    @PostMapping
    public TreePoint create(@RequestBody TreePoint treePoint){
        return null;
    }

    @PutMapping
    public TreePoint update(@RequestBody TreePoint treePoint){
        return null;
    }

    @DeleteMapping
    public void delete(@RequestBody TreePoint treePoint){
        return;
    }
}