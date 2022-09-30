package com.codeclan.examples.models;

import javax.persistence.*;

@Entity
@Table(name="nodes")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "db_id")
    private Long db_id;

    @Column(name = "id")
    private int id;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(name = "visited")
    boolean visited;

    @ManyToOne
    @JoinColumn(name = "maze_grid_id", nullable = false)
    private MazeGrid mazeGrid;

    @ManyToOne
    @JoinColumn(name = "graph_id", nullable = false)
    private Graph graph;

    public Node(int id, int x, int y, MazeGrid mazeGrid, Graph graph){
        this.id = id;
        this.x = x;
        this.y = y;
        visited = false;
        this.mazeGrid = mazeGrid;
        this.graph = graph;
    }

    public Node() {

    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public MazeGrid getMazeGrid() {
        return mazeGrid;
    }

    public void setMazeGrid(MazeGrid mazeGrid) {
        this.mazeGrid = mazeGrid;
    }

    public Long getDb_id() {
        return db_id;
    }

    public void setDb_id(Long db_id) {
        this.db_id = db_id;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void visit(){
        visited = true;
    }

    public void unvisit(){
        visited = false;
    }

    public boolean isVisited(){
        return this.visited;
    }
}
