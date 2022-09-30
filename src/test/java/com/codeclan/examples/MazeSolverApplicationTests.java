package com.codeclan.examples;

import com.codeclan.examples.models.*;
import com.codeclan.examples.repositories.CoordinateRepository;
import com.codeclan.examples.repositories.GraphRepository;
import com.codeclan.examples.repositories.MazeGridRepository;
import com.codeclan.examples.repositories.NodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class MazeSolverApplicationTests {

	@Autowired
	CoordinateRepository coordinateRepository;

	@Autowired
	NodeRepository nodeRepository;

	@Autowired
	MazeGridRepository mazeGridRepository;

	@Autowired
	GraphRepository graphRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createMaze(){
		MazeGrid mazeGrid1 = new MazeGrid(5,5);
		mazeGridRepository.save(mazeGrid1);
	}

	@Test
	public void createCoordinateAndMaze(){
		MazeGrid mazeGrid2 = new MazeGrid(6,6);
		mazeGridRepository.save(mazeGrid2);
		Coordinate coordinate1 = new Coordinate(0,0, CoordType.START, mazeGrid2 );
		coordinateRepository.save(coordinate1);
	}

	@Test
	public void createGraph(){
		Graph graph1 = new Graph();
		graphRepository.save(graph1);
	}

	@Test
	public void createNode(){
		MazeGrid mazeGrid3 = new MazeGrid(7,7);
		mazeGridRepository.save(mazeGrid3);
		Graph graph2 = new Graph();
		graphRepository.save(graph2);
		Node node1 = new Node(0,0,0,mazeGrid3, graph2);
		nodeRepository.save(node1);

	}

}
