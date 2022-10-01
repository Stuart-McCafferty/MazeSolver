package com.codeclan.examples.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class MazeGrid {

    private int height;

    private int width;

    private List<Coordinate> listOfCoordinates;

    private List<Node> nodeList;

    public MazeGrid(int height, int width, List<Coordinate> listOfCoordinates){
        this.height = height;
        this.width = width;
        this.listOfCoordinates = listOfCoordinates;
        nodeList = new ArrayList<Node>();
    }



    public int getListOfCoordinatesCount() {
        return this.listOfCoordinates.size();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
    @JsonIgnore
    public List<Node> getNodeList(){
        int counter = 0;
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if (!"WALL".equals(listOfCoordinate.coordType.getCoordinateType())) {
                Node nodeTemp = new Node(counter, listOfCoordinate.getX(), listOfCoordinate.getY());
                nodeList.add(nodeTemp);
                counter += 1;
            }
        }
        return nodeList;
    }


    //move these two to graph.java
    public Node getStartNode(){
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("START".equals(listOfCoordinate.coordType.getCoordinateType())) {
                return new Node(0, listOfCoordinate.getX(), listOfCoordinate.getY());
            }
        }
        return null;
    }

    public Node getEndNode(){
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("END".equals(listOfCoordinate.coordType.getCoordinateType())) {
                return new Node(0, listOfCoordinate.getX(), listOfCoordinate.getY());
            }
        }
        return null;
    }
}
