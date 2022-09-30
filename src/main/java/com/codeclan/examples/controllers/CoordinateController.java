package com.codeclan.examples.controllers;

import com.codeclan.examples.models.Coordinate;
import com.codeclan.examples.repositories.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CoordinateController {

    @Autowired
    CoordinateRepository coordinateRepository;

    @GetMapping(value = "/coordinates")
    public List<Coordinate> getAllCoordinates(){
        return coordinateRepository.findAll();
    }

    @GetMapping(value = "/coordinates/{id}")
    public Optional<Coordinate> getCoordinate(@PathVariable Long id){
        return coordinateRepository.findById(id);
    }
}
