package de.kopf3.mshack22backend.api.controller;

import de.kopf3.mshack22backend.api.wsto.PointFilter;
import de.kopf3.mshack22backend.persistence.document.*;
import de.kopf3.mshack22backend.persistence.document.Image;
import de.kopf3.mshack22backend.persistence.repository.ActivityPointRepository;
import org.bson.types.ObjectId;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController("points")
@RequestMapping("points")
@CrossOrigin("*")
public class PointController {


    private final ActivityPointRepository pointRepository;

    public PointController(ActivityPointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping("{id}")
    public ActivityPoint getById(@PathVariable String id){
        return pointRepository.findById(new ObjectId(id)).orElseThrow();
    }
    @GetMapping()
    public List<ActivityPoint> getAll(){
        return pointRepository.findAll();
    }

    /**
     *
     * radius in m
     * @return list of points in radius
     */
    @PostMapping("filter")
    public List<ActivityPoint> getByLocationAndRadiusAndTypes(@Valid @RequestBody PointFilter filter){
        return pointRepository.getByRadius(new Point(filter.getX(), filter.getY()), 1d/6370000 * filter.getRadius(), filter.getTypes());
    }

    @GetMapping("byUser")
    public List<ActivityPoint> getByAuthor(String userId){
        return pointRepository.findByUserId(new ObjectId(userId));
    }

    @PostMapping("byType")
    public List<ActivityPoint> getByTypes(@RequestBody List<String> types){
        return pointRepository.findByTypeIn(types);
    }

    @PostMapping
    public ActivityPoint create(@RequestBody ActivityPoint activityPoint){
        return pointRepository.save(activityPoint);
    }

    @PutMapping
    public ActivityPoint update(@RequestBody ActivityPoint activityPoint){
        return pointRepository.save(activityPoint);
    }

    @DeleteMapping
    public void delete(@RequestBody ActivityPoint activityPoint){
        pointRepository.delete(activityPoint);
    }



}
