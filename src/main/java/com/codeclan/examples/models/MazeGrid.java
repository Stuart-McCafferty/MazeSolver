package com.codeclan.examples.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="maze_grids")
public class MazeGrid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "height")
    private final int height;

    @Column(name = "width")
    private final int width;

    //one to many
    @OneToMany(mappedBy="mazeGrid")
    @JsonIgnoreProperties({"mazeGrid"})
    private List<Coordinate> listOfCoordinates;

    @OneToMany(mappedBy="mazeGrid")
    @JsonIgnoreProperties({"mazeGrid"})
    private List<Node> nodeList;

    public MazeGrid(int height, int width){
        this.height = height;
        this.width = width;
        this.listOfCoordinates = new ArrayList<Coordinate>();
        this.nodeList = new ArrayList<Node>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Node> getNodeList(){
        int counter = 0;
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if (!"WALL".equals(listOfCoordinate.coordType.getCoordinateType())) {
                Node nodeTemp = new Node(counter, listOfCoordinate.getX(), listOfCoordinate.getY(), this.getStartNode().getMazeGrid(), this.getStartNode().getGraph());
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
                return new Node(0, listOfCoordinate.getX(), listOfCoordinate.getY(), this.getStartNode().getMazeGrid(), this.getStartNode().getGraph());
            }
        }
        return null;
    }

    public Node getEndNode(){
        for (Coordinate listOfCoordinate : listOfCoordinates) {
            if ("END".equals(listOfCoordinate.coordType.getCoordinateType())) {
                return new Node(0, listOfCoordinate.getX(), listOfCoordinate.getY(), this.getEndNode().getMazeGrid(), this.getEndNode().getGraph());
            }
        }
        return null;
    }
}
