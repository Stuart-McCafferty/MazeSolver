package com.codeclan.examples.repositories;

import com.codeclan.examples.models.MazeGrid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MazeGridRepository extends JpaRepository<MazeGrid, Long> {
}
