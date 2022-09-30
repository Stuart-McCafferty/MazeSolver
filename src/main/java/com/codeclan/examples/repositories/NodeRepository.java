package com.codeclan.examples.repositories;

import com.codeclan.examples.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
}
