package com.codeclan.examples.models;

import javax.persistence.*;

@Entity
@Table(name="coordinates")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(name = "coordinate_type")
    public CoordType coordType;

    @ManyToOne
    @JoinColumn(name = "maze_grid_id", nullable = false)
    private MazeGrid mazeGrid;

    public Coordinate(){

    }
    public Coordinate(int x, int y, CoordType coordType, MazeGrid mazeGrid){
        this.x = x;
        this.y = y;
        this.coordType = coordType;
        this.mazeGrid = mazeGrid;
    }

    public MazeGrid getMazeGrid() {
        return mazeGrid;
    }

    public void setMazeGrid(MazeGrid mazeGrid) {
        this.mazeGrid = mazeGrid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }


}
