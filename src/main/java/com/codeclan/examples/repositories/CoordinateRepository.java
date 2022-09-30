package com.codeclan.examples.repositories;

import com.codeclan.examples.models.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
