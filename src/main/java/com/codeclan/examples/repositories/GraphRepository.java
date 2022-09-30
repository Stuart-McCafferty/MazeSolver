package com.codeclan.examples.repositories;

import com.codeclan.examples.models.Graph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphRepository extends JpaRepository<Graph, Long> {
}
