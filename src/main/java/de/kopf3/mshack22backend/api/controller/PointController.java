package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.persistence.document.*;
import de.kopf3.mshack22backend.persistence.document.Image;
import de.kopf3.mshack22backend.persistence.repository.ActivityPointRepository;
import org.bson.types.ObjectId;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collections;
import java.util.List;


@RestController("points")
@RequestMapping("points")
public class PointController {


    private final ActivityPointRepository pointRepository;

    public PointController(ActivityPointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping("{id}")
    public ActivityPoint getById(@PathVariable String id){
        return pointRepository.findById(new ObjectId(id)).orElseThrow();
    }

    /**
     *
     * @param radius in m
     * @return list of points in radius
     */
    @GetMapping()
    public List<TreePoint> getByLocationAndRadius(double x, double y, int radius){
        return Collections.emptyList();
        //return pointRepository.getByRadius(new Point(x, y), 1d/6370000 * radius);
    }

    @GetMapping("byUser")
    public List<ActivityPoint> getByAuthor(String userId){
        return null;
    }

    @PostMapping
    public ActivityPoint create(@RequestBody ActivityPoint activityPoint){
        return null;
    }

    @PutMapping
    public ActivityPoint update(@RequestBody ActivityPoint activityPoint){
        return null;
    }

    @DeleteMapping
    public void delete(@RequestBody ActivityPoint activityPoint){
        return;
    }



}
