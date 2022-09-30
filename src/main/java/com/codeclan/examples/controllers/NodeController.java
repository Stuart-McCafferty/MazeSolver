package com.codeclan.examples.controllers;

import com.codeclan.examples.models.Coordinate;
import com.codeclan.examples.models.Node;
import com.codeclan.examples.repositories.CoordinateRepository;
import com.codeclan.examples.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NodeController {

    @Autowired
    NodeRepository nodeRepository;

    @GetMapping(value = "/nodes")
    public List<Node> getAllNodes(){
        return nodeRepository.findAll();
    }

    @GetMapping(value = "/nodes/{id}")
    public Optional<Node> getNode(@PathVariable Long id){
        return nodeRepository.findById(id);
    }
}
