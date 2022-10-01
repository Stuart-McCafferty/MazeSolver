package com.codeclan.examples.controllers;

import com.codeclan.examples.models.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


@RestController
public class SolverController {

    @GetMapping(value = "/maze/1")
    public List<Coordinate> getMazeOne(){
        Coordinate coordinate1 = new Coordinate(0,4, CoordType.START);
        Coordinate coordinate2 = new Coordinate(1,4,CoordType.PATH);
        Coordinate coordinate3 = new Coordinate(2,4,CoordType.PATH);
        Coordinate coordinate4 = new Coordinate(3,4,CoordType.WALL);
        Coordinate coordinate5 = new Coordinate(4,4,CoordType.END);
        Coordinate coordinate6 = new Coordinate(0,3,CoordType.PATH);
        Coordinate coordinate7 = new Coordinate(1,3,CoordType.WALL);
        Coordinate coordinate8 = new Coordinate(2,3,CoordType.PATH);
        Coordinate coordinate9 = new Coordinate(3,3,CoordType.WALL);
        Coordinate coordinate10 = new Coordinate(4,3,CoordType.PATH);
        Coordinate coordinate11 = new Coordinate(0,2,CoordType.PATH);
        Coordinate coordinate12 = new Coordinate(1,2, CoordType.WALL);
        Coordinate coordinate13 = new Coordinate(2,2,CoordType.PATH);
        Coordinate coordinate14 = new Coordinate(3,2,CoordType.WALL);
        Coordinate coordinate15 = new Coordinate(4,2,CoordType.PATH);
        Coordinate coordinate16 = new Coordinate(0,1,CoordType.PATH);
        Coordinate coordinate17 = new Coordinate(1,1,CoordType.WALL);
        Coordinate coordinate18 = new Coordinate(2,1,CoordType.PATH);
        Coordinate coordinate19 = new Coordinate(3,1,CoordType.PATH);
        Coordinate coordinate20 = new Coordinate(4,1,CoordType.PATH);
        Coordinate coordinate21 = new Coordinate(0,0,CoordType.PATH);
        Coordinate coordinate22 = new Coordinate(1,0,CoordType.WALL);
        Coordinate coordinate23 = new Coordinate(2,0,CoordType.PATH);
        Coordinate coordinate24 = new Coordinate(3,0,CoordType.PATH);
        Coordinate coordinate25 = new Coordinate(4,0,CoordType.PATH);
        List<Coordinate> listOfCoordinates = new ArrayList<>();
        listOfCoordinates.add(coordinate1);
        listOfCoordinates.add(coordinate2);
        listOfCoordinates.add(coordinate3);
        listOfCoordinates.add(coordinate4);
        listOfCoordinates.add(coordinate5);
        listOfCoordinates.add(coordinate6);
        listOfCoordinates.add(coordinate7);
        listOfCoordinates.add(coordinate8);
        listOfCoordinates.add(coordinate9);
        listOfCoordinates.add(coordinate10);
        listOfCoordinates.add(coordinate11);
        listOfCoordinates.add(coordinate12);
        listOfCoordinates.add(coordinate13);
        listOfCoordinates.add(coordinate14);
        listOfCoordinates.add(coordinate15);
        listOfCoordinates.add(coordinate16);
        listOfCoordinates.add(coordinate17);
        listOfCoordinates.add(coordinate18);
        listOfCoordinates.add(coordinate19);
        listOfCoordinates.add(coordinate20);
        listOfCoordinates.add(coordinate21);
        listOfCoordinates.add(coordinate22);
        listOfCoordinates.add(coordinate23);
        listOfCoordinates.add(coordinate24);
        listOfCoordinates.add(coordinate25);

        return listOfCoordinates;
    }

    @GetMapping(value = "/solve/1")
    public ArrayList<Stack<Node>> solveMaze1(){

        Coordinate coordinate1 = new Coordinate(0,4, CoordType.START);
        Coordinate coordinate2 = new Coordinate(1,4,CoordType.PATH);
        Coordinate coordinate3 = new Coordinate(2,4,CoordType.PATH);
        Coordinate coordinate4 = new Coordinate(3,4,CoordType.WALL);
        Coordinate coordinate5 = new Coordinate(4,4,CoordType.END);
        Coordinate coordinate6 = new Coordinate(0,3,CoordType.PATH);
        Coordinate coordinate7 = new Coordinate(1,3,CoordType.WALL);
        Coordinate coordinate8 = new Coordinate(2,3,CoordType.PATH);
        Coordinate coordinate9 = new Coordinate(3,3,CoordType.WALL);
        Coordinate coordinate10 = new Coordinate(4,3,CoordType.PATH);
        Coordinate coordinate11 = new Coordinate(0,2,CoordType.PATH);
        Coordinate coordinate12 = new Coordinate(1,2, CoordType.WALL);
        Coordinate coordinate13 = new Coordinate(2,2,CoordType.PATH);
        Coordinate coordinate14 = new Coordinate(3,2,CoordType.WALL);
        Coordinate coordinate15 = new Coordinate(4,2,CoordType.PATH);
        Coordinate coordinate16 = new Coordinate(0,1,CoordType.PATH);
        Coordinate coordinate17 = new Coordinate(1,1,CoordType.WALL);
        Coordinate coordinate18 = new Coordinate(2,1,CoordType.PATH);
        Coordinate coordinate19 = new Coordinate(3,1,CoordType.PATH);
        Coordinate coordinate20 = new Coordinate(4,1,CoordType.PATH);
        Coordinate coordinate21 = new Coordinate(0,0,CoordType.PATH);
        Coordinate coordinate22 = new Coordinate(1,0,CoordType.WALL);
        Coordinate coordinate23 = new Coordinate(2,0,CoordType.PATH);
        Coordinate coordinate24 = new Coordinate(3,0,CoordType.PATH);
        Coordinate coordinate25 = new Coordinate(4,0,CoordType.PATH);
        List<Coordinate> listOfCoordinates = new ArrayList<>();
        listOfCoordinates.add(coordinate1);
        listOfCoordinates.add(coordinate2);
        listOfCoordinates.add(coordinate3);
        listOfCoordinates.add(coordinate4);
        listOfCoordinates.add(coordinate5);
        listOfCoordinates.add(coordinate6);
        listOfCoordinates.add(coordinate7);
        listOfCoordinates.add(coordinate8);
        listOfCoordinates.add(coordinate9);
        listOfCoordinates.add(coordinate10);
        listOfCoordinates.add(coordinate11);
        listOfCoordinates.add(coordinate12);
        listOfCoordinates.add(coordinate13);
        listOfCoordinates.add(coordinate14);
        listOfCoordinates.add(coordinate15);
        listOfCoordinates.add(coordinate16);
        listOfCoordinates.add(coordinate17);
        listOfCoordinates.add(coordinate18);
        listOfCoordinates.add(coordinate19);
        listOfCoordinates.add(coordinate20);
        listOfCoordinates.add(coordinate21);
        listOfCoordinates.add(coordinate22);
        listOfCoordinates.add(coordinate23);
        listOfCoordinates.add(coordinate24);
        listOfCoordinates.add(coordinate25);
        MazeGrid mazeGrid = new MazeGrid(5,5, listOfCoordinates);

        List<Node> nodeArrayList = new ArrayList<>(mazeGrid.getNodeList());
        Node startNode = mazeGrid.getStartNode();
//        Node endNode = mazeGrid.getEndNode();
        Node endNode =  new Node(0,0, 0);

        Graph graph = new Graph(nodeArrayList, startNode, endNode);
        graph.addNodes();
        graph.findEdges();
        return graph.DFS(startNode);

    }
}
